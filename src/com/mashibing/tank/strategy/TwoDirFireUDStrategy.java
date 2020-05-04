package com.mashibing.tank.strategy;

import com.mashibing.tank.*;

/**
 * @ClassName TwoDirFireUDStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TwoDirFireUDStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bX = t.getX() + ResourceManager.goodTankU.getWidth()/2 - ResourceManager.bulletU.getWidth()/2;
        int bY = t.getY() + ResourceManager.goodTankU.getHeight()/2 - ResourceManager.bulletU.getHeight()/2;

        TankFrame.INSTANCE.add(new Bullet(bX, bY, Dir.UP, t.getGroup()));
        TankFrame.INSTANCE.add(new Bullet(bX, bY, Dir.DOWN, t.getGroup()));

    }
}
