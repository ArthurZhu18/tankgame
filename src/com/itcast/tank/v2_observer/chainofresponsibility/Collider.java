package com.itcast.tank.v2_observer.chainofresponsibility;

import com.itcast.tank.v2_observer.AbstractGameObject;

/**
 * @ClassName Collider
 * @Description TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Collider {
    //return true chain go on, return false chain go off
    boolean collide(AbstractGameObject go1, AbstractGameObject go2);
}
