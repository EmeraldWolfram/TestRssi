package com.example.testrssi.model;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class Coordinate {
    private Float coorX;
    private Float coorY;
    private Long timeUsed;
    private Float actualX;
    private Float actualY;
    private Double error;

    public Coordinate(){
        coorX   = (float) 0.0;
        coorY   = (float) 0.0;
        timeUsed= (long) 0;
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

    public void setActual(Float actualX, Float actualY) {
        this.actualX = actualX;
        this.actualY = actualY;
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

    public void computeError() {
        if(actualX != null && actualY != null) {
            error = Math.sqrt((coorX - actualX) * (coorX - actualX) + (coorY - actualY) * (coorY - actualY));
        }
    }

    public String getError() {
        if(error == null) {
            return "N/A";
        }
        return String.format(Locale.ENGLISH, "%.4f", error);
    }

    @NotNull
    @Override
    public String toString() {
        return "(" + coorX.toString() + ", " + coorY.toString() + ") : (" + timeUsed.toString() + "ns)" ;
    }

    public String toCsvString(){
        return coorX.toString() + ", " + coorY.toString() + ", " + timeUsed.toString() + "ns," + getError() + ",";
    }

}
