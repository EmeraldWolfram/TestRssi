package com.example.testrssi.MvpInterface;

import android.content.Context;

import com.example.testrssi.model.Coordinate;


public interface MvpRationAlgo {
    interface MvpView {
        void reportError(String msg);
        void showCoordinate0(Coordinate coor);
        void showCoordinate1(Coordinate coor);
        void showCoordinate2(Coordinate coor);
        void showCoordinate3(Coordinate coor);
        void writeToFile(String data);

    }

    interface MvpPresenterV {
        void setupAccessPoints();
        void setupWriter();
        void onRefresh(Float actualX, Float actualY);
    }

    interface MvpModel {}
}
