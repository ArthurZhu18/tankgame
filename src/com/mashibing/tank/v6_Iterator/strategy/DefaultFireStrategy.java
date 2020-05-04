package com.mashibing.tank.v6_Iterator.strategy;

import com.mashibing.tank.v6_Iterator.Bullet;
import com.mashibing.tank.v6_Iterator.Player;
import com.mashibing.tank.v6_Iterator.ResourceManager;
import com.mashibing.tank.v6_Iterator.TankFrameSingleton;

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
