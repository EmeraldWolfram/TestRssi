package com.example.testrssi.model;

public class CramerAlgoBot {

    private float x0, x1, x2, y0, y1, y2;
    private float xConst1, xConst2, yConst1, yConst2;
    private float det;


    public CramerAlgoBot(){}

    public CramerAlgoBot(float x0, float x1, float x2, float y0, float y1, float y2) {
        this.x0  = x0; this.x1 = x1; this.x2 = x2;
        this.y0  = y0; this.y1 = y1; this.y2 = y2;

        xConst1 = 2 * (x1 - x0);
        xConst2 = 2 * (x2 - x1);

        yConst1 = 2 * (y1 - y0);
        yConst2 = 2 * (y2 - y1);

        det     = (xConst1 * yConst2 - xConst2 * yConst1);
    }


    public void setupApCoor(float x0, float x1, float x2, float y0, float y1, float y2) {

        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;

        xConst1 = 2 * (x1 - x0);
        xConst2 = 2 * (x2 - x1);

        yConst1 = 2 * (y1 - y0);
        yConst2 = 2 * (y2 - y1);

        det     = (xConst1 * yConst2 - xConst2 * yConst1);
    }

    public Coordinate determineCoordinate(float d0, float d1, float d2) {
        Coordinate result;
        long nanoTime;
        float subConst1, subConst2;

        result      = new Coordinate();
        nanoTime= System.nanoTime();
        subConst1   = x1 * x1 - x0 * x0 + y1 * y1 - y0 * y0 + d0 * d0 * 100 - d1 * d1 * 100;
        subConst2   = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1 + d1 * d1 * 100 - d2 * d2 * 100;

        result.setCoorX((subConst1 * yConst2 - subConst2 * yConst1) / (det));
        result.setCoorY((subConst2 * xConst1 - subConst1 * xConst2) / (det));
        result.setTimeUsed(System.nanoTime() - nanoTime);
        return result;
    }



}
