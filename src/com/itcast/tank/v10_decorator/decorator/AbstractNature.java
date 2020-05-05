package com.itcast.tank.v10_decorator.decorator;

import java.awt.*;

/**
 * @ClassName AbstractNature
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public abstract class AbstractNature implements WallDecorator {

    private WallImpl nuture;

    public AbstractNature(WallImpl nature) {
        this.nuture = nature;
    }

    @Override
    public void paint(Graphics g){
        nuture.paint(g);
    }

}
