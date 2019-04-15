package com.example.testrssi.MvpInterface;

import android.content.Context;

import com.example.testrssi.model.Coordinate;


public interface MvpRationAlgo {
    interface MvpView {
        void reportError(String msg);
        void showCoordinate0(Coordinate coor);
        //void showComputeTime(Long nanoTime);
        void showCoordinate1(Coordinate coor);
        //void showComputeTime1(Long nanoTime);
        void showCoordinate2(Coordinate coor);
        //void showComputeTime2(Long nanoTime);
        void showCoordinate3(Coordinate coor);
        void writeToFile(String data);

    }

    interface MvpPresenterV {
        void setupAccessPoints();
        void setupWriter();
        void onRefresh();
    }

    interface MvpModel {}
}
