package com.example.testrssi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.List;

public interface MvpScan {
    interface MvpModel {
        void scanWiFi(WifiManager wifiManager);
    }

    interface MvpPresenterM {
        void populateList(List<ScanResult> scanResults);
    }

    interface MvpPresenterV {
        void scanWiFi(Context context);
    }

    interface MvpView {}
}
