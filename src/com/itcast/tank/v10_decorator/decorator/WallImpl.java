package com.itcast.tank.v10_decorator.decorator;

import com.itcast.tank.v10_decorator.AbstractGameObject;

import java.awt.*;

/**
 * @ClassName Wall
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class WallImpl extends AbstractGameObject implements WallDecorator {
    private int x, y, width, height;
    private Rectangle rect;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public WallImpl(int x, int y, int width, int height) {
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
