package com.itcast.tank.v4_chainofresponsibility.strategy;

import com.itcast.tank.v4_chainofresponsibility.Player;

/**
 * @ClassName AbstractFireStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface FireStrategy {
    public void fire(Player p);
}
