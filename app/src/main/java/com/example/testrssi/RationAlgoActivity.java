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


public class RationAlgoActivity extends AppCompatActivity implements MvpRationAlgo.MvpView {

    private MvpRationAlgo.MvpPresenterV taskPresenter;
    private TextView timeUsedView;
    private TextView coorXView;
    private TextView coorYView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ration_algo);
        bindView();
        initMvp();
    }

    private void bindView(){
        this.timeUsedView   = findViewById(R.id.timeUsed);
        this.coorXView      = findViewById(R.id.coordinateX);
        this.coorYView      = findViewById(R.id.coordinateY);

    }

    private void initMvp(){
        WifiManager wifi    = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        this.taskPresenter  = new RationAlgoPresenter(this, wifi);
        this.taskPresenter.setupAccessPoints();
    }

    public void onRefreshClicked(View view) {
        this.taskPresenter.onRefresh();
    }

    @Override
    public void reportError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComputeTime(Long nanoTime) {
        String timeStr;
        timeStr = nanoTime.toString() + "ns";
        timeUsedView.setText(timeStr);
    }

    @Override
    public void showCoordinate(Coordinate coor) {
        String xStr = "X: " + coor.getCoorX().toString();
        String yStr = "Y: " + coor.getCoorY().toString();
        coorXView.setText(xStr);
        coorYView.setText(yStr);
    }
}
