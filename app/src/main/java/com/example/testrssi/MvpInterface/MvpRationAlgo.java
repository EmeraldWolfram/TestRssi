package com.example.testrssi.MvpInterface;

import com.example.testrssi.model.Coordinate;

public interface MvpRationAlgo {
    interface MvpView {
        void reportError(String msg);
        void showCoordinate(Coordinate coor);
        void showComputeTime(Long nanoTime);
    }

    interface MvpPresenterV {
        void setupAccessPoints();
        void onRefresh();
    }

    interface MvpModel {}
}
