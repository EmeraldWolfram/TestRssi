package com.example.testrssi.model;

import org.junit.Test;

public class CoGravityTuningTest {

    CoGravityAlgoBot bot;


    @Test
    public void testDetermineCoordinate_1() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-47.6);
        d[1]    = RssiConverter.convertRssiToD((float)-50);
        d[2]    = RssiConverter.convertRssiToD((float)-47.1);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)32.5, (float)32.5);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_2() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-50.6);
        d[1]    = RssiConverter.convertRssiToD((float)-52.1);
        d[2]    = RssiConverter.convertRssiToD((float)-59.4);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)38.75, (float)10.0);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_3() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-51);
        d[1]    = RssiConverter.convertRssiToD((float)-58.4);
        d[2]    = RssiConverter.convertRssiToD((float)-50.2);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)10.0, (float)38.75);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_4() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-54.8);
        d[1]    = RssiConverter.convertRssiToD((float)-50.7);
        d[2]    = RssiConverter.convertRssiToD((float)-50.4);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)48.75, (float)48.75);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_5() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-16);
        d[1]    = RssiConverter.convertRssiToD((float)-59.3);
        d[2]    = RssiConverter.convertRssiToD((float)-53.8);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)2.5, (float)2.5);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_6() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-56.7);
        d[1]    = RssiConverter.convertRssiToD((float)-11.9);
        d[2]    = RssiConverter.convertRssiToD((float)-57);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)75.0, (float)20.0);
        target.computeError();
        System.out.println(target.toCsvString());
    }

    @Test
    public void testDetermineCoordinate_7() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-58.4);
        d[1]    = RssiConverter.convertRssiToD((float)-58.4);
        d[2]    = RssiConverter.convertRssiToD((float)-14.2);

        //System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        target.setActual((float)20.0, (float)75.0);
        target.computeError();
        System.out.println(target.toCsvString());
    }
}
