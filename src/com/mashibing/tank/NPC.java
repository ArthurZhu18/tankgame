package com.mashibing.tank;

import com.mashibing.tank.strategy.DefaultFireStrategy;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName NPC
 * @Description //npcs
 * @Author ArthurZhu
 * @Version 1.0
 */

public class NPC extends Tank {
    //tank moving speed
    public static final int SPEED = 5;
    private int oldX, oldY;

    public NPC(int x, int y, Dir dir) {
        super(x, y, dir);
        this.setMoving(true);
        this.setGroup(Group.BAD);
        oldX = x;
        oldY = y;
        this.setWight(ResourceManager.badTankU.getWidth());
        this.setHeight(ResourceManager.badTankU.getHeight());
    }

    @Override
    public void paint(Graphics g) {

        if (!this.isLive()) return;

        switch (this.getDir()) {
            case UP:
                g.drawImage(ResourceManager.badTankU, this.getX(), this.getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.badTankD, this.getX(), this.getY(), null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.badTankL, this.getX(), this.getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.badTankR, this.getX(), this.getY(), null);
        }

        move();

    }

    @Override
    public void move() {
        if ( !this.isMoving() ) return;
        oldX = getX();
        oldY = getY();

        switch (this.getDir()){
            case UP:
                this.setY(this.getY()-SPEED);
                break;
            case DOWN:
                this.setY(this.getY()+SPEED);
                break;
            case LEFT:
                this.setX(this.getX()-SPEED);
                break;
            case RIGHT:
                this.setX(this.getX()+SPEED);
                break;
        }

        boundsCheck();

        randomDir();
        if (r.nextInt(100)>90)
            fire();
    }

    /*
     * @Description // NPC certain random direction
     * @Param []
     * @return void
     **/
    private Random r = new Random();
    private void randomDir() {
        if(r.nextInt(100)>90)
            this.setDir(Dir.randomDir());
    }

    /*
     * @Description //while bullet across the border of TankFrame,
     * remove bullet in bullets
     * @Param []
     * @return void
     **/
    private void boundsCheck() {
        if (getX()<0 || getY()<30 || getX() + getWight()>TankFrame.GAME_WIDTH
                || getY() + getHeight()>TankFrame.GAME_HEIGHT){
            this.back();
        }
    }

    private void back() {
        this.setX(oldX);
        this.setY(oldY);
    }

    @Override
    public void fire() {
        FireStrategy strategy = new DefaultFireStrategy();
        strategy.fire(this);
    }
}
