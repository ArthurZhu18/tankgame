package com.itcast.tank.v1_singleten.chainofresponsibility;

import com.itcast.tank.v1_singleten.AbstractGameObject;
import com.itcast.tank.v1_singleten.Bullet;
import com.itcast.tank.v1_singleten.Wall;

/**
 * @ClassName BulletWallColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class BulletWallColliderImpl implements Collider {

    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof Wall){
            Bullet b = (Bullet) go1;
            Wall w = (Wall) go2;


            if (b.isLive()){
                if (b.getRect().intersects(w.getRect())){
                    b.die();
                    return false;
                }
            }
        }else if (go2 instanceof Bullet && go1 instanceof Wall){
            return collide(go2,go1);
        }

        return true;
    }
}
