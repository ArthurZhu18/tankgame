package com.itcast.tank.v10_decorator.chainofresponsibility;

import com.itcast.tank.v10_decorator.AbstractGameObject;
import com.itcast.tank.v10_decorator.NPC;
import com.itcast.tank.v10_decorator.decorator.WallImpl;

/**
 * @ClassName BulletTankColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TankWallColliderImpl implements Collider {

    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof NPC && go2 instanceof WallImpl){
            NPC tank = (NPC) go1;
            WallImpl w = (WallImpl) go2;
            if (tank.getRect().intersects(w.getRect())){
                tank.back();
            }
        }else if (go1 instanceof WallImpl && go2 instanceof NPC){
            collide(go2,go1);
        }

        return true;
    }
}
