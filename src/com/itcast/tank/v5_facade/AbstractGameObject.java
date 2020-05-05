package com.itcast.tank.v5_facade;

import java.awt.*;
import java.io.Serializable;

/**
 * @ClassName com.mashibing.tank.v1.AbstractGameObject
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public abstract class AbstractGameObject implements Serializable {

    public abstract void paint(Graphics g);

    public abstract boolean isLive();
}
