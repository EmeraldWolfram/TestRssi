package com.example.testrssi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class RationAlgoActivity extends AppCompatActivity {

    private List<ScanResult> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ration_algo);
    }

    public void doCalculation(){
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(wifi.startScan()) {
            results = wifi.getScanResults();
            //breakDownCoordinate();
        } else {
            Toast.makeText(this, "Start SCAN return NO", Toast.LENGTH_SHORT).show();
        }

    }

    public void onRefreshClicked(View view) {
        // do REFRESH
    }
}
