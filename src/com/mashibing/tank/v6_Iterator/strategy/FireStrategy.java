package com.mashibing.tank.v6_Iterator.strategy;

import com.mashibing.tank.v6_Iterator.Player;

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
