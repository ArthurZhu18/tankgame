package com.itcast.tank.v9_Iterator;

import java.util.Random;

public enum Dir {
    // tank's four directions
    LEFT, UP, RIGHT, DOWN;

    private static Random random = new Random();

    public static Dir randomDir(){
        return values()[random.nextInt(values().length)];
    }
}
