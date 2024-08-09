package com.rihejiu.nustarlib.utils;

import java.util.Random;

public class Utils {
    public static boolean shouldExecute(double probability) {
        Random random = new Random();
        return random.nextDouble() < probability; // 小于 probability 时返回 true，大于等于时返回 false
    }
}
