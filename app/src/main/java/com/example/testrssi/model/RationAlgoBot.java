package com.example.testrssi.model;

public class RationAlgoBot {

    private float x0, x1, x2, y0, y1, y2;
    //private int[] x, y;
    private float mTanA, mTanB;


    public RationAlgoBot(){}

    public RationAlgoBot(float x0, float x1, float x2, float y0, float y1, float y2) {
        float m1, m2;

        this.x0  = x0; this.x1 = x1; this.x2 = x2;
        this.y0  = y0; this.y1 = y1; this.y2 = y2;


        m1  = (y1 - y0) / (x1 - x0);
        m2  = (y2 - y0) / (x2 - x0);

        mTanA   = -1 / m1;
        mTanB   = -1 / m2;
    }


    public void setupApCoor(float x0, float x1, float x2, float y0, float y1, float y2) {
        float m1, m2;

        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;


        m1 = (y1 - y0) / (x1 - x0);
        m2 = (y2 - y0) / (x2 - x0);

        mTanA = -1 / m1;
        mTanB = -1 / m2;
    }

    public Coordinate determineCoordinate(float d0, float d1, float d2) {
        Coordinate result;
        float yTanA, xTanA, yTanB, xTanB, cTanA, cTanB;

        result  = new Coordinate();
        yTanA   = (y1 - y0) * (d0 / (d1 + d0)) + y0;
        xTanA   = (x1 - x0) * (d0 / (d1 + d0)) + x0;

        yTanB   = (y2 - y0) * (d0 / (d2 + d0)) + y0;
        xTanB   = (x2 - x0) * (d0 / (d2 + d0)) + x0;


        cTanA   = yTanA - mTanA * xTanA;
        cTanB   = yTanB - mTanB * xTanB;

        result.setCoorX((cTanB - cTanA) / (mTanA - mTanB));
        result.setCoorY((mTanB*cTanA - mTanA*cTanB) / (mTanB - mTanA));

        return result;
    }



}
