package com.example.testrssi;

import android.net.wifi.ScanResult;

import com.example.testrssi.model.RssiConverter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private List<ScanResult> results;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testIntegerToFloat() {
        int y1, y0, x1, x0;
        float m1;

        y1  = 17; y0 = 3;
        x1  = 4; x0 = 1;


        m1 = (float) (y1 - y0) / (x1 - x0);

        System.out.print(m1);

    }

    @Test
    public void testRationAlgoBot(){
        float dVal;

        dVal = RssiConverter.convertRssiToD(-60);

        assertEquals(9.888, dVal, 0.001);
    }

    @Test
    public void testStringToFloat(){
        float val;

        val = Float.parseFloat("100");
        System.out.print(val);
        assertEquals(100.00, val, 0.01);
    }
}