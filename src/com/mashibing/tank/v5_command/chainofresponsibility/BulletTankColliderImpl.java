package com.mashibing.tank.v5_command.chainofresponsibility;

import com.mashibing.tank.v5_command.AbstractGameObject;
import com.mashibing.tank.v5_command.Bullet;
import com.mashibing.tank.v5_command.NPC;

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
