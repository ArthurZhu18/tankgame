package com.itcast.tank.v5_facade.strategy;

import com.itcast.tank.v5_facade.*;

/**
 * @ClassName FourDirFireStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Player t) {
        int bX = t.getX() + ResourceManager.goodTankU.getWidth()/2 - ResourceManager.bulletU.getWidth()/2;
        int bY = t.getY() + ResourceManager.goodTankU.getHeight()/2 - ResourceManager.bulletU.getHeight()/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            TankFrameSingleton.INSTANCE.getGm().add(new Bullet(bX, bY, dir, t.getGroup()));
        }
    }
}
