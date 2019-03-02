package com.example.testrssi.presenter;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.example.testrssi.model.AccessPoint;
import com.example.testrssi.model.Coordinate;
import com.example.testrssi.model.RationAlgoBot;

import java.util.ArrayList;
import java.util.List;

public class RationAlgoPresenter {

    private WifiManager wifiManager;
    private RationAlgoBot bot;
    private List<ScanResult> results;
    private List<AccessPoint> accessPoints;
    private Coordinate  targetCoor;

    public RationAlgoPresenter(WifiManager wifiManager) {
        this.wifiManager    = wifiManager;
        this.accessPoints   = new ArrayList<>();
        this.bot            = new RationAlgoBot();
    }

    public void setupAccessPoints(){
        AccessPoint accessPoint;

        if(this.wifiManager.startScan()) {
            results = this.wifiManager.getScanResults();
            for (ScanResult result: results) {
                if(result.SSID.contains("StevenFYP")) {
                    accessPoint = new AccessPoint(result);
                    accessPoints.add(accessPoint);
                }
            }

            this.bot.setupApCoor(
                    this.accessPoints.get(0).getCoordinate().getCoorX().intValue(),
                    this.accessPoints.get(1).getCoordinate().getCoorX().intValue(),
                    this.accessPoints.get(2).getCoordinate().getCoorX().intValue(),
                    this.accessPoints.get(0).getCoordinate().getCoorY().intValue(),
                    this.accessPoints.get(1).getCoordinate().getCoorY().intValue(),
                    this.accessPoints.get(2).getCoordinate().getCoorY().intValue()
            );


        } else {
            // ToDo: View report Scan Error
        }

    }

    public void onRefresh(){
        float[] d;
        if (accessPoints.size() != 3) {
            // ToDo: View report FATAL ERROR
        }
        if(this.wifiManager.startScan()) {
            results = this.wifiManager.getScanResults();
            d   = new float[accessPoints.size()];
            for (int i = 0; i < accessPoints.size(); i++) {
                AccessPoint ap = accessPoints.get(i);
                ap.findMyRssi(results);
                d[i]    = ap.getTargetDistance();
            }
            // track time start

            targetCoor  = bot.determineCoordinate(d[0], d[1], d[2]);
            // track time end
            // ToDo: View displayCoordinate
            // ToDo: View display timeStart - timeEnd
        } else {
            // ToDo: View report Scan Error
        }
    }


}
