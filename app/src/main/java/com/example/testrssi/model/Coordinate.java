package com.example.testrssi.model;

public class Coordinate {
    private Float coorX;
    private Float coorY;
    // time used;

    public Coordinate(){
        coorX   = (float) 0.0;
        coorY   = (float) 0.0;
    }

    public void setCoorX(Float coorX) {
        this.coorX = coorX;
    }

    public void setCoorY(Float coorY) {
        this.coorY = coorY;
    }

    public Float getCoorX() {
        return coorX;
    }

    public Float getCoorY() {
        return coorY;
    }
}