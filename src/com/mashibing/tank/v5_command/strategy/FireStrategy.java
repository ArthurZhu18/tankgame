package com.mashibing.tank.v5_command.strategy;

import com.mashibing.tank.v5_command.Player;

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
