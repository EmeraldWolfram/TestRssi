package com.example.testrssi.presenter;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.example.testrssi.MvpInterface.MvpRationAlgo;
import com.example.testrssi.model.AccessPoint;
import com.example.testrssi.model.CoGravityAlgoBot;
import com.example.testrssi.model.Coordinate;
import com.example.testrssi.model.CramerAlgoBot;
import com.example.testrssi.model.GaussianAlgoBot;
import com.example.testrssi.model.RationAlgoBot;

import java.util.ArrayList;
import java.util.List;

public class RationAlgoPresenter implements MvpRationAlgo.MvpPresenterV {

    private WifiManager wifiManager;
    private RationAlgoBot bot0;
    private CramerAlgoBot bot1;
    private GaussianAlgoBot bot2;
    private CoGravityAlgoBot bot3;
    private List<ScanResult> results;
    private List<AccessPoint> accessPoints;

    private MvpRationAlgo.MvpView taskView;

    public RationAlgoPresenter(MvpRationAlgo.MvpView taskView, WifiManager wifiManager) {
        this.taskView       = taskView;
        this.wifiManager    = wifiManager;
        this.accessPoints   = new ArrayList<>();
        this.bot0           = new RationAlgoBot();
        this.bot1           = new CramerAlgoBot();
        this.bot2           = new GaussianAlgoBot();
        this.bot3           = new CoGravityAlgoBot();
    }

    public void setupWriter(){

        if(accessPoints.size() != 3) {
            taskView.reportError("FATAL: Number of AP is not equal to 3");
        } else {
            taskView.writeToFile(accessPoints.get(0).getName() + ","
                    + accessPoints.get(1).getName() + ","
                    + accessPoints.get(2).getName() + ","
                    + "Ration (X), Ration (Y), Ration (ns), Error (0.1m),"
                    + "Cramer (X), Cramer (Y), Cramer (ns), Error (0.1m),"
                    + "Gaussian(X), Gaussian(Y), Gaussian (ns), Error (0.1m),"
                    + "Center Gravity (X), Center Gravity (Y), Center Gravity (ns), Error (0.1m)\n"
            );
        }

    }

    public void setupAccessPoints(){
        AccessPoint accessPoint;

        if(this.wifiManager.startScan()) {
            results = this.wifiManager.getScanResults();
            for (ScanResult result: results) {
                if(result.SSID.contains("Steven")) {
                    accessPoint = new AccessPoint(result);
                    accessPoints.add(accessPoint);
                }
            }

            if(accessPoints.size() != 3) {
                taskView.reportError("FATAL: Number of AP is not equal to 3");
            } else {
                this.bot0.setupApCoor(
                        this.accessPoints.get(0).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(0).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorY().intValue()
                );

                this.bot1.setupApCoor(
                        this.accessPoints.get(0).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(0).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorY().intValue()
                );
                this.bot2.setupApCoor(
                        this.accessPoints.get(0).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(0).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorY().intValue()
                );

                this.bot3.setupApCoor(
                        this.accessPoints.get(0).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorX().intValue(),
                        this.accessPoints.get(0).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(1).getCoordinate().getCoorY().intValue(),
                        this.accessPoints.get(2).getCoordinate().getCoorY().intValue()

                );

            }
        } else {
            taskView.reportError("ERROR: Failed to Scan");
        }

    }

    @Override
    public void onRefresh(Float actualX, Float actualY){
        float[]     d;
        Coordinate  targetCoor;

        if (accessPoints.size() != 3) {
            taskView.reportError("FATAL: Number of AP is not equal to 3");
        } else if(this.wifiManager.startScan()) {
            results = this.wifiManager.getScanResults();
            d   = new float[accessPoints.size()];
            for (int i = 0; i < accessPoints.size(); i++) {
                AccessPoint ap = accessPoints.get(i);
                ap.findMyRssi(results);
                d[i]    = ap.getTargetDistance();
            }

            taskView.writeToFile(d[0] + "," + d[1] + "," + d[2] + ",");

            targetCoor  = bot0.determineCoordinate(d[0], d[1], d[2]);
            targetCoor.setActual(actualX, actualY);
            targetCoor.computeError();
            taskView.showCoordinate0(targetCoor);
            taskView.writeToFile(targetCoor.toCsvString());

            targetCoor  = bot1.determineCoordinate(d[0], d[1], d[2]);
            targetCoor.setActual(actualX, actualY);
            targetCoor.computeError();
            taskView.showCoordinate1(targetCoor);
            taskView.writeToFile(targetCoor.toCsvString());

            targetCoor  = bot2.determineCoordinate(d[0], d[1], d[2]);
            targetCoor.setActual(actualX, actualY);
            targetCoor.computeError();
            taskView.showCoordinate2(targetCoor);
            taskView.writeToFile(targetCoor.toCsvString());

            targetCoor  = bot3.determineCoordinate(d[0], d[1], d[2]);
            targetCoor.setActual(actualX, actualY);
            targetCoor.computeError();
            taskView.showCoordinate3(targetCoor);
            taskView.writeToFile(targetCoor.toCsvString());


            taskView.writeToFile("\n");

        } else {
            taskView.reportError("ERROR: Failed to Scan");
        }
    }




}
