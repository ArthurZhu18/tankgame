package com.itcast.tank.v6_mediator.chainofresponsibility;

import com.itcast.tank.v6_mediator.AbstractGameObject;

import java.io.Serializable;

/**
 * @ClassName Collider
 * @Description collide interface, judge two objects collide
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Collider extends Serializable {
    //return true chain go on, return false chain go off
    boolean collide(AbstractGameObject go1, AbstractGameObject go2);
}
