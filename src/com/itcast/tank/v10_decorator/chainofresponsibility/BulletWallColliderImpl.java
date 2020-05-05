package com.itcast.tank.v10_decorator.chainofresponsibility;

import com.itcast.tank.v10_decorator.AbstractGameObject;
import com.itcast.tank.v10_decorator.Bullet;
import com.itcast.tank.v10_decorator.decorator.WallImpl;

/**
 * @ClassName BulletWallColliderImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class BulletWallColliderImpl implements Collider {

    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof WallImpl){
            Bullet b = (Bullet) go1;
            WallImpl w = (WallImpl) go2;


            if (b.isLive()){
                if (b.getRect().intersects(w.getRect())){
                    b.die();
                    return false;
                }
            }
        }else if (go2 instanceof Bullet && go1 instanceof WallImpl){
            return collide(go2,go1);
        }

        return true;
    }
}
