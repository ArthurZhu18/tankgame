package com.mashibing.tank.v3_chainofresponsibility.chainofresponsibility;

import com.mashibing.tank.v3_chainofresponsibility.AbstractGameObject;

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
