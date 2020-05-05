package com.itcast.tank.v3_strategy.strategy;

import com.itcast.tank.v3_strategy.Bullet;
import com.itcast.tank.v3_strategy.Player;
import com.itcast.tank.v3_strategy.ResourceManager;
import com.itcast.tank.v3_strategy.TankFrameSingleton;

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

        TankFrameSingleton.INSTANCE.add(new Bullet(bX, bY, p.getDir(), p.getGroup()));
    }
}
