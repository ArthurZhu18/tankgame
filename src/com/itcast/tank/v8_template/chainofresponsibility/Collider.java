package com.itcast.tank.v8_template.chainofresponsibility;

import com.itcast.tank.v8_template.AbstractGameObject;

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
