package com.itcast.tank.v1_singleten;

import java.awt.*;

/**
 * @ClassName Explode
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Explode extends AbstractGameObject {

    private int x, y;
    private int width, height;
    private int step = 0;
    private boolean live = true;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = ResourceManager.explodes[0].getWidth();
        this.height = ResourceManager.explodes[0].getHeight();
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    /*
     * @Description //paint bullet
     * @Param [g]
     * @return void
     **/
    public void paint(Graphics g) {

        if (!live) return;

        g.drawImage(ResourceManager.explodes[step], x, y, null);
        step++;

        if (step>=ResourceManager.explodes.length) {
            this.die();
        }

    }

    private void die() {
        this.live = false;
    }

}
