package com.example.testrssi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoGravityAlgoBotTest {
    CoGravityAlgoBot bot;

    @Test
    public void determineCoordinate_perfect() {
        Float d[];
        long nanoTime;

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-53.388);
        d[1]    = RssiConverter.convertRssiToD((float)-53.388);
        d[2]    = RssiConverter.convertRssiToD((float)-53.388);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        nanoTime            = target.getTimeUsed();
        System.out.println(target.toString());
        System.out.println(nanoTime);
    }

    @Test
    public void testDetermineCoordinate_1() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-47.6667);
        d[1]    = RssiConverter.convertRssiToD((float)-49.6667);
        d[2]    = RssiConverter.convertRssiToD((float)-47);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_2() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-51);
        d[1]    = RssiConverter.convertRssiToD((float)-53.6667);
        d[2]    = RssiConverter.convertRssiToD((float)-60);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_3() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-51);
        d[1]    = RssiConverter.convertRssiToD((float)-59.3333);
        d[2]    = RssiConverter.convertRssiToD((float)-50.3333);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_4() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-54.6667);
        d[1]    = RssiConverter.convertRssiToD((float)-50.6667);
        d[2]    = RssiConverter.convertRssiToD((float)-50.3333);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_5() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-17);
        d[1]    = RssiConverter.convertRssiToD((float)-58.6667);
        d[2]    = RssiConverter.convertRssiToD((float)-54.3333);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_6() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-55.3333);
        d[1]    = RssiConverter.convertRssiToD((float)-10.6667);
        d[2]    = RssiConverter.convertRssiToD((float)-57);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }

    @Test
    public void testDetermineCoordinate_7() {
        Float d[];

        bot = new CoGravityAlgoBot();
        bot.setupApCoor((float)0.0, (float)77.5, (float)20, (float)0.0, (float)20, (float)77.5);

        d   = new Float[3];

        d[0]    = RssiConverter.convertRssiToD((float)-58.3333);
        d[1]    = RssiConverter.convertRssiToD((float)-58.3333);
        d[2]    = RssiConverter.convertRssiToD((float)-13.6667);

        System.out.println("0:" + d[0] + ", 1:" + d[1] + ", 2:" + d[2]);

        Coordinate target   = bot.determineCoordinate(d[0], d[1], d[2]);
        System.out.println(target.toString());
    }
}