package com.example.testrssi.model;

public class CoGravityAlgoBot {
    private float x0, x1, x2, y0, y1, y2;


    public CoGravityAlgoBot(){}

    public CoGravityAlgoBot(float x0, float x1, float x2, float y0, float y1, float y2) {
        this.x0  = x0; this.x1 = x1; this.x2 = x2;
        this.y0  = y0; this.y1 = y1; this.y2 = y2;
    }


    public void setupApCoor(float x0, float x1, float x2, float y0, float y1, float y2) {

        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;

    }

    public Coordinate determineCoordinate(float d0, float d1, float d2) {
        Coordinate result;
        long nanoTime;

        result      = new Coordinate();
        nanoTime    = System.nanoTime();
        float w0 = (float) Math.pow((d0*10), -2);
        float w1 = (float) Math.pow((d1*10), -2);
        float w2 = (float) Math.pow((d2*10), -2);

        result.setCoorX((w0 * x0 + w1 * x1 + w2 * x2)/(w0 + w1 + w2));
        result.setCoorY((w0 * y0 + w1 * y1 + w2 * y2)/(w0 + w1 + w2));
        result.setTimeUsed(System.nanoTime() - nanoTime);

        return result;
    }

}
