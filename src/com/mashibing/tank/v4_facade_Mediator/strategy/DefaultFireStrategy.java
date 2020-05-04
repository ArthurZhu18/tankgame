package com.mashibing.tank.v4_facade_Mediator.strategy;

import com.mashibing.tank.v4_facade_Mediator.Bullet;
import com.mashibing.tank.v4_facade_Mediator.Player;
import com.mashibing.tank.v4_facade_Mediator.ResourceManager;
import com.mashibing.tank.v4_facade_Mediator.TankFrameSingleton;

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
