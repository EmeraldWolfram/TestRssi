package com.example.testrssi;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ScanResultHolder  extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    TextView ssidView;
    TextView macView;
    TextView rssiView;

    public ScanResultHolder(View view) {
        super(view);

        ssidView    = view.findViewById(R.id.ssid_view);
        macView     = view.findViewById(R.id.mac_view);
        rssiView    = view.findViewById(R.id.rssi_view);
    }

    public void setSsidView(String ssid) {
        ssidView.setText(ssid);
    }

    public void setMacView(String mac) {
        this.macView.setText(mac);
    }

    @SuppressLint("SetTextI18n")
    public void setRssiView(Integer rssi) {
        this.rssiView.setText(rssi.toString());
    }
}
