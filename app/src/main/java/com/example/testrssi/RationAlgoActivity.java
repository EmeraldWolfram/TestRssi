package com.example.testrssi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testrssi.MvpInterface.MvpRationAlgo;
import com.example.testrssi.model.Coordinate;
import com.example.testrssi.presenter.RationAlgoPresenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class RationAlgoActivity extends AppCompatActivity implements MvpRationAlgo.MvpView {

    private MvpRationAlgo.MvpPresenterV taskPresenter;
    private TextView timeUsedView0;
    private TextView coorView0;

    private TextView timeUsedView1;
    private TextView coorView1;

    private TextView timeUsedView2;
    private TextView coorView2;

    private TextView timeUsedView3;
    private TextView coorView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ration_algo);
        bindView();
        initMvp();
    }

    private void bindView(){
        this.timeUsedView0  = findViewById(R.id.time_used_0);
        this.coorView0      = findViewById(R.id.coordinate_0);

        this.timeUsedView1  = findViewById(R.id.time_used_1);
        this.coorView1      = findViewById(R.id.coordinate_1);

        this.timeUsedView2  = findViewById(R.id.time_used_2);
        this.coorView2      = findViewById(R.id.coordinate_2);

        this.timeUsedView3  = findViewById(R.id.time_used_3);
        this.coorView3      = findViewById(R.id.coordinate_3);

    }

    private void initMvp(){
        WifiManager wifi    = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        this.taskPresenter  = new RationAlgoPresenter(this, wifi);
        this.taskPresenter.setupAccessPoints();
        this.taskPresenter.setupWriter();
    }

    public void onRefreshClicked(View view) {
        this.taskPresenter.onRefresh();
    }

    @Override
    public void reportError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCoordinate0(Coordinate coor) {
        String coorStr  = "(X: " + coor.getCoorX().toString()
                + ", Y: " + coor.getCoorY().toString() + ")";
        String timeStr  = coor.getTimeUsed().toString();
        coorView0.setText(coorStr);
        timeUsedView0.setText(timeStr);
    }

    @Override
    public void showCoordinate1(Coordinate coor) {
        String coorStr  = "(X: " + coor.getCoorX().toString()
                + ", Y: " + coor.getCoorY().toString() + ")";
        String timeStr  = coor.getTimeUsed().toString();

        coorView1.setText(coorStr);
        timeUsedView1.setText(timeStr);
    }

    @Override
    public void showCoordinate2(Coordinate coor) {
        String coorStr  = "(X: " + coor.getCoorX().toString()
                + ", Y: " + coor.getCoorY().toString() + ")";
        String timeStr  = coor.getTimeUsed().toString();

        coorView2.setText(coorStr);
        timeUsedView2.setText(timeStr);
    }

    @Override
    public void showCoordinate3(Coordinate coor) {
        String coorStr  = "(X: " + coor.getCoorX().toString()
                + ", Y: " + coor.getCoorY().toString() + ")";
        String timeStr  = coor.getTimeUsed().toString();
        coorView3.setText(coorStr);
        timeUsedView3.setText(timeStr);
    }

    @Override
    public void writeToFile(String data) {
        try{
            //File path = getFilesDir();
            File file = new File("/mnt/sdcard/data", "RSS_Record.csv");

            //OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("RSS.txt", Context.MODE_APPEND));
            FileOutputStream writer = new FileOutputStream(file, true);
            writer.write(data.getBytes());
            writer.close();
        } catch (IOException e) {
            reportError(e.toString());
        }
    }
}
