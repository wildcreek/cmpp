package com.killxdcj.cmpp.utils;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:38
 */
public class RandomUtils {
    private static final Random rand = new Random();

    public static int nextInt() {
        return rand.nextInt();
    }

    public static int nextInt(int bound) {
        return rand.nextInt(bound);
    }
}
