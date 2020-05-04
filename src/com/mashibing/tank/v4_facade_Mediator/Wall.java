package com.mashibing.tank.v4_facade_Mediator;

import java.awt.*;

/**
 * @ClassName Wall
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Wall extends AbstractGameObject {
    private int x, y, width, height;
    private Rectangle rect;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.rect = new Rectangle(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(c);
    }

    @Override
    public boolean isLive() {
        return true;
    }

    public Rectangle getRect() {
        return this.rect;
    }


    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", rect=" + rect +
                '}';
    }
}
