package com.itcast.tank.v1_singleten.strategy;

import com.itcast.tank.v1_singleten.Bullet;
import com.itcast.tank.v1_singleten.Player;
import com.itcast.tank.v1_singleten.ResourceManager;
import com.itcast.tank.v1_singleten.TankFrameSingleton;

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
