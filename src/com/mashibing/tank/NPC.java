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

public class NPC extends AbstractGameObject {
    private int x, y;
    private Dir dir;
    private boolean moving = true;
    private Group group;
    private boolean live = true;
    private int wight,height;
    //tank moving speed
    public static final int SPEED = 5;
    private int oldX, oldY;
    private Random r = new Random();
    private Rectangle rectTank;

    public NPC(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = Group.BAD;
        this.oldX = x;
        this.oldY = y;
        this.wight = ResourceManager.badTankU.getWidth();
        this.height = ResourceManager.badTankU.getHeight();
        this.rectTank = new Rectangle(x, y, wight, height);
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


    public void setDir(Dir dir) {
        this.dir = dir;
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

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public void paint(Graphics g) {

        if (!this.isLive()) return;

        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.badTankU, this.x, this.y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.badTankD, this.x, this.y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.badTankL, this.x, this.y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.badTankR, this.x, this.y, null);
        }

        move();

        //update the rectTank location
        rectTank.x = x;
        rectTank.y = y;

    }

    public void move() {
        if ( !this.moving ) return;
        oldX = x;
        oldY = y;

        switch (dir){
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
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
        if (x<0 || y<30 || x + wight>TankFrame.GAME_WIDTH
                || y + height>TankFrame.GAME_HEIGHT){
            this.back();
        }
    }

    public void back() {
        this.x = oldX;
        this.y = oldY;
    }

    public void fire() {
        int bX = x + wight / 2 - Bullet.W / 2;
        int bY = y + height / 2 - Bullet.H / 2;

        TankFrame.INSTANCE.add(new Bullet(bX, bY, dir, group));
    }

    public void die() {
        live = false;
        TankFrame.INSTANCE.add( new Explode(x ,y));
    }

    public Rectangle getRect() {
        return rectTank;
    }
}
