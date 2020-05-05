package com.itcast.tank.v10_decorator.decorator;

import java.awt.*;

/**
 * @ClassName Grass
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Grass extends AbstractNature {


    public Grass(WallImpl nature) {
        super(nature);
    }

    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(100,200,100,100);
        g.setColor(c);
    }
}
