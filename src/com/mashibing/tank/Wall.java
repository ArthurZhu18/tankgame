package com.mashibing.tank;

import java.awt.*;

/**
 * @ClassName Wall
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Wall extends AbstractGameObject {
    private int x, y, wight, height;

    public Wall(int x, int y, int wight, int height) {
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x, y, wight, height);
        g.setColor(c);
    }
}
