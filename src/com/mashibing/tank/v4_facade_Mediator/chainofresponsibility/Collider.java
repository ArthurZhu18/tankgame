package com.mashibing.tank.v4_facade_Mediator.chainofresponsibility;

import com.mashibing.tank.v4_facade_Mediator.AbstractGameObject;

import java.io.Serializable;

/**
 * @ClassName Collider
 * @Description TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Collider extends Serializable {
    //return true chain go on, return false chain go off
    boolean collide(AbstractGameObject go1, AbstractGameObject go2);
}
