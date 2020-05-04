package com.mashibing.tank.v6_Iterator.Iterator;

import com.mashibing.tank.v6_Iterator.AbstractGameObject;
import com.mashibing.tank.v6_Iterator.Dir;
import com.mashibing.tank.v6_Iterator.Group;
import com.mashibing.tank.v6_Iterator.ResourceManager;

import java.awt.*;

/**
 * @ClassName Landmine
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Landmine extends AbstractGameObject {

    private int x, y;
    private boolean live = true;
    private Rectangle rectBullet;

    private int w = ResourceManager.square1.getWidth();
    private int h = ResourceManager.square1.getHeight();


    public Landmine(int x, int y) {
        this.x = x;
        this.y = y;

        this.rectBullet = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        if (!this.isLive()) return;

        g.drawImage(ResourceManager.square1, this.x, this.y, null);
    }

    @Override
    public boolean isLive() {
        return this.live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void die() {
        this.setLive(false);
    }

    public Rectangle getRect(){
        return rectBullet;
    }
}
