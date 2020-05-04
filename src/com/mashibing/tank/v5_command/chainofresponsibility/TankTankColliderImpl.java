package com.mashibing.tank.v5_command.chainofresponsibility;

import com.mashibing.tank.v5_command.AbstractGameObject;
import com.mashibing.tank.v5_command.NPC;

/**
 * @ClassName TankTankColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TankTankColliderImpl implements Collider {

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
