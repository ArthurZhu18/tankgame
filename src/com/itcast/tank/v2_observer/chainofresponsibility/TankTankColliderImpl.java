package com.itcast.tank.v2_observer.chainofresponsibility;

import com.itcast.tank.v2_observer.AbstractGameObject;
import com.itcast.tank.v2_observer.NPC;

/**
 * @ClassName TankTankColliderImpl
 * @Description //collide between Tank and Tank
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TankTankColliderImpl implements Collider {

    /*
     * @Description //is judge NPC and NPC collide.
     * @Param [go1, go2]
     * @return boolean
     **/
    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if(go1 != go2 && go1 instanceof NPC && go2 instanceof NPC) {

            NPC t1 = (NPC) go1;
            NPC t2 = (NPC) go2;
            if(t1.isLive() && t2.isLive()) {
                if(t1.getRect().intersects(t2.getRect())) {
                    t1.back();
                    t2.back();
                }
            }
        }
        return true;
    }
}
