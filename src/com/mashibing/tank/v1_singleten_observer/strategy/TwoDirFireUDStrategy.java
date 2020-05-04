package com.mashibing.tank.v1_singleten_observer.strategy;

import com.mashibing.tank.v1_singleten_observer.*;

/**
 * @ClassName TwoDirFireUDStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TwoDirFireUDStrategy implements FireStrategy {

    @Override
    public void fire(Player t) {
        int bX = t.getX() + ResourceManager.goodTankU.getWidth()/2 - ResourceManager.bulletU.getWidth()/2;
        int bY = t.getY() + ResourceManager.goodTankU.getHeight()/2 - ResourceManager.bulletU.getHeight()/2;

        TankFrameSingleton.INSTANCE.add(new Bullet(bX, bY, Dir.UP, t.getGroup()));
        TankFrameSingleton.INSTANCE.add(new Bullet(bX, bY, Dir.DOWN, t.getGroup()));

    }
}
