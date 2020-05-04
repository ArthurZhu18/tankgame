package com.mashibing.tank.v1_singleten;

import java.awt.*;

/**
 * @ClassName Bullet
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Bullet extends AbstractGameObject {

    private int x, y;
    private Dir dir;
    private boolean live = true;
    private Group group;
    private int w = ResourceManager.bulletU.getWidth();
    private int h = ResourceManager.bulletU.getHeight();

    public static final int W = ResourceManager.bulletU.getWidth();
    public static final int H = ResourceManager.bulletU.getHeight();
    public static final int SPEED = 3;

    private Rectangle rectBullet;

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

        this.rectBullet = new Rectangle(x, y, w, h);
    }

    /*
     * @Description //paint bullet
     * @Param [g]
     * @return void
     **/
    @Override
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

        //update rect location
        rectBullet.x = x;
        rectBullet.y = y;
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
    /*public void collidedWithTank(Player tank){
        if ( !this.isLive() || !tank.isLive()) return;
        if (this.group == tank.getGroup()) return;

        Rectangle rectBullet = new Rectangle(x, y,
                ResourceManager.bulletU.getWidth(),ResourceManager.bulletU.getHeight());
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(),
                ResourceManager.goodTankU.getWidth(),ResourceManager.goodTankU.getHeight());

        if (rectBullet.intersects(rectTank)){

            this.die();
            tank.die();
        }

    }*/

    public void collidedWithTank(NPC tank){

    }

    public Rectangle getRect(){
        return rectBullet;
    }

    public void die() {
        this.setLive(false);
    }

    public Group getGroup() {
        return group;
    }

    /*
     * @Description //while bullet across the border of TankFrame,
     * remove bullet in bullets
     * @Param []
     * @return void
     **/
    private void boundsCheck() {
        if (x<0 || y<30 || x> TankFrameSingleton.GAME_WIDTH || y> TankFrameSingleton.GAME_HEIGHT){
            live = false;
        }
    }


    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", live=" + live +
                ", group=" + group +
                ", w=" + w +
                ", h=" + h +
                ", rectBullet=" + rectBullet +
                '}';
    }
}
