package com.itcast.tank.v6_mediator.chainofresponsibility;

import com.itcast.tank.v6_mediator.AbstractGameObject;
import com.itcast.tank.v6_mediator.Bullet;
import com.itcast.tank.v6_mediator.NPC;

import java.awt.*;

/**
 * @ClassName BulletTankColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class BulletTankColliderImpl implements Collider {

    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof NPC){
            Bullet b = (Bullet) go1;
            NPC npc = (NPC) go2;

            if ( !b.isLive() || !npc.isLive()) return false;
            if (b.getGroup() == npc.getGroup()) return true;

            //Rectangle rectBullet = new Rectangle(x, y,
            //        ResourceManager.bulletU.getWidth(),ResourceManager.bulletU.getHeight());
            Rectangle rectTank = npc.getRect();

            if (b.getRect().intersects(rectTank)){
                b.die();
                npc.die();
                return false;
            }

//            b.collidedWithTank(npc);
        }else if (go1 instanceof NPC && go2 instanceof Bullet){
            return collide(go2,go1);
        }
        return true;
    }
}
