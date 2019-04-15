package com.example.testrssi.model;

import org.jetbrains.annotations.NotNull;

public class Coordinate {
    private Float coorX;
    private Float coorY;
    private Long timeUsed;

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

    public void setTimeUsed(Long timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Float getCoorX() {
        return coorX;
    }

    public Float getCoorY() {
        return coorY;
    }

    public Long getTimeUsed() {
        return timeUsed;
    }

    @NotNull
    @Override
    public String toString() {
        return "(" + coorX.toString() + ", " + coorY.toString() + ": " + timeUsed.toString() + "ns)" ;
    }

    public String toCsvString(){
        return coorX.toString() + ", " + coorY.toString() + ", " + timeUsed.toString() + "ns,";
    }

}
