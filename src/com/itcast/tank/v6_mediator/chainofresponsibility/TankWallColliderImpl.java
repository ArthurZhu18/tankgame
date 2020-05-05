package com.itcast.tank.v6_mediator.chainofresponsibility;

import com.itcast.tank.v6_mediator.AbstractGameObject;
import com.itcast.tank.v6_mediator.NPC;
import com.itcast.tank.v6_mediator.Wall;

/**
 * @ClassName BulletTankColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TankWallColliderImpl implements Collider {

    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof NPC && go2 instanceof Wall){
            NPC tank = (NPC) go1;
            Wall w = (Wall) go2;
            if (tank.getRect().intersects(w.getRect())){
                tank.back();
            }
        }else if (go1 instanceof Wall && go2 instanceof NPC){
            collide(go2,go1);
        }

        return true;
    }
}
