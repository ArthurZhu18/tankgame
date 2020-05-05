package com.itcast.tank.v9_Iterator.strategy;

import com.itcast.tank.v9_Iterator.Player;

import java.io.Serializable;

/**
 * @ClassName AbstractFireStrategy
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface FireStrategy extends Serializable {
    public void fire(Player p);
}
