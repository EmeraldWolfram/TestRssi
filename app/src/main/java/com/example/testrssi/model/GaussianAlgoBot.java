package com.example.testrssi.model;

public class GaussianAlgoBot {
    private float x0, x1, x2, y0, y1, y2;
    private float xConst1, xConst2, yConst1, yConst2, rationConst, fractionConst;

    public GaussianAlgoBot(){}

    public GaussianAlgoBot(float x0, float x1, float x2, float y0, float y1, float y2) {
        this.x0  = x0; this.x1 = x1; this.x2 = x2;
        this.y0  = y0; this.y1 = y1; this.y2 = y2;

        xConst1 = 2 * (x1 - x0);
        xConst2 = 2 * (x2 - x1);

        yConst1 = 2 * (y1 - y0);
        yConst2 = 2 * (y2 - y1);

        rationConst     = xConst2 / xConst1;
        fractionConst   = yConst2 - rationConst * yConst1;
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

        rationConst     = xConst2 / xConst1;
        fractionConst   = yConst2 - rationConst * yConst1;
    }

    public Coordinate determineCoordinate(float d0, float d1, float d2) {
        Coordinate result;
        long nanoTime;
        float subConst1, subConst2;
        float y;

        result      = new Coordinate();
        nanoTime    = System.nanoTime();
        subConst1   = x1 * x1 - x0 * x0 + y1 * y1 - y0 * y0 + d0 * d0 * 100 - d1 * d1 * 100;
        subConst2   = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1 + d1 * d1 * 100 - d2 * d2 * 100;

        y   = (subConst2 - rationConst * subConst1) / (fractionConst);
        result.setCoorY(y);
        result.setCoorX((subConst1 - yConst1 * y) / xConst1);
        result.setTimeUsed(System.nanoTime() - nanoTime);

        return result;
    }
}
