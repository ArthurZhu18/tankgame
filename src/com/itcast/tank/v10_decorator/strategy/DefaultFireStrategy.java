package com.itcast.tank.v10_decorator.strategy;

import com.itcast.tank.v10_decorator.ResourceManager;
import com.itcast.tank.v10_decorator.TankFrameSingleton;
import com.itcast.tank.v10_decorator.Bullet;
import com.itcast.tank.v10_decorator.Player;

/**
 * @ClassName DefaultFireStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Player p) {
        int bX = p.getX() + ResourceManager.goodTankU.getWidth()/2 - ResourceManager.bulletU.getWidth()/2;
        int bY = p.getY() + ResourceManager.goodTankU.getHeight()/2 - ResourceManager.bulletU.getHeight()/2;

        TankFrameSingleton.INSTANCE.getGm().add(new Bullet(bX, bY, p.getDir(), p.getGroup()));
    }
}
