package com.itcast.tank.v3_strategy.strategy;

import com.itcast.tank.v3_strategy.*;

/**
 * @ClassName TwoDirFireLRStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TwoDirFireLRStrategy implements FireStrategy {

    @Override
    public void fire(Player t) {
        int bX = t.getX() + ResourceManager.goodTankU.getWidth()/2 - ResourceManager.bulletU.getWidth()/2;
        int bY = t.getY() + ResourceManager.goodTankU.getHeight()/2 - ResourceManager.bulletU.getHeight()/2;

        TankFrameSingleton.INSTANCE.add(new Bullet(bX, bY, Dir.LEFT, t.getGroup()));
        TankFrameSingleton.INSTANCE.add(new Bullet(bX, bY, Dir.RIGHT, t.getGroup()));

    }
}
