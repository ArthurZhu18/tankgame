package com.mashibing.tank;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Bullet {

    private int x, y;
    private Dir dir;
    private boolean live = true;
    private Group group;
    public static final int SPEED = 3;

    public boolean isLive() {
        return this.live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
    }

    /*
     * @Description //paint bullet
     * @Param [g]
     * @return void
     **/
    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
        }

        move();
    }

    /*
     * @Description //bullet moving
     * @Param []
     * @return void
     **/
    private void move() {
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }

        boundsCheck();
    }

    /*
     * @Description // Is the judge bullet and tank collided?
     * @Param [tank]
     * @return void
     **/
    public void collidedWithTank(Tank tank){
        if ( this.isLive() || !tank.isLive()) return;
        if (this.group == tank.getGroup()) return;

        Rectangle rectBullet = new Rectangle(x, y,
                ResourceManager.bulletU.getWidth(),ResourceManager.bulletU.getHeight());
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(),
                ResourceManager.goodTankU.getWidth(),ResourceManager.goodTankU.getHeight());

        if (rectBullet.intersects(rectTank)){

            this.die();
            tank.die();
        }

    }

    private void die() {
        this.setLive(false);
    }


    /*
     * @Description //while bullet across the border of TankFrame,
     * remove bullet in bullets
     * @Param []
     * @return void
     **/
    private void boundsCheck() {
        if (x<0 || y<30 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

}
