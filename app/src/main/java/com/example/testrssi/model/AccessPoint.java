package com.example.testrssi.model;

import android.net.wifi.ScanResult;

import java.util.List;

public class AccessPoint {
    private Coordinate coordinate;
    private String name;
    private String macAddress;
    private Float targetDistance;
    
    public AccessPoint(Coordinate coordinate, String name, String macAddress) {
        this.coordinate = coordinate;
        this.name       = name;
        this.macAddress = macAddress;
    }

    public AccessPoint(ScanResult scanResult){
        this.macAddress = scanResult.BSSID;
        this.name       = scanResult.SSID;
        String[] split  = scanResult.SSID.split("_");
        this.coordinate = new Coordinate();
        this.coordinate.setCoorX(Float.parseFloat(split[1]));
        this.coordinate.setCoorY(Float.parseFloat(split[2]));
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Float getTargetDistance() {
        return targetDistance;
    }

    public Integer findMyRssi(List<ScanResult> results) {
        for (ScanResult result : results) {
            if(result.SSID.equals(name)) {
                this.targetDistance = RssiConverter.convertRssiToD(result.level);
                return result.level;
            }
        }

        return 0;
    }
    
}
