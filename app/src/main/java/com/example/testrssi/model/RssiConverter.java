package com.example.testrssi.model;

public class RssiConverter {

    public static float convertRssiToD(int rssi){
        double exp = (27.55 - (20 * Math.log10(2412)) + Math.abs(rssi)) / 20.0;
        return (float) Math.pow(10.0, exp);
    }

}
