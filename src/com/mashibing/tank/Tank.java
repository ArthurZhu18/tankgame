package com.mashibing.tank;

import com.mashibing.tank.strategy.DefaultFireStrategy;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ClassName com.mashibing.tank.Tank
 * @Description //Abstract tank class, is all tank's father
 * @Author ArthurZhu
 * @Version 1.0
 */

public abstract class Tank {

    //x横坐标  y纵坐标
    private int x, y;
    //tank direction
    private Dir dir;
    //moving state
    private boolean moving;
    //tank type
    private Group group;
    //tank live
    private boolean live = true;
    private int wight,height;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*
     * @Description //paint tank
     * @Param [g]
     * @return void
     **/
    public abstract void paint(Graphics g);

    /*
     * @Description //tank moving
     * @Param []
     * @return void
     **/
    public abstract void move();

    public void die() {
        this.setLive(false);
        TankFrame.INSTANCE.add( new Explode(x ,y));
    }

    /*
     * @Description //bank shoot enemy
     * @Param []
     * @return void
     **/
    public abstract void fire();


}
