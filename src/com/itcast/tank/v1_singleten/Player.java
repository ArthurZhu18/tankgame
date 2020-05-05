package com.itcast.tank.v1_singleten;

import com.itcast.tank.v1_singleten.strategy.FireStrategy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Player
 * @Description //player
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Player extends AbstractGameObject {
    private int x, y;
    private Dir dir;
    private boolean moving;
    private Group group;
    private boolean live = true;
    private int wight,height;
    private boolean bUp, bDown, bLeft, bRight;
    public static final int SPEED = 5;


    public Player(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=Group.GOOD;
        this.moving=false;
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

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }


    /*
     * @Description //paint tank
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {
        if (!this.isLive()) return;

        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.goodTankU, this.x, this.y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.goodTankD, this.x, this.y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.goodTankL, this.x, this.y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.goodTankR, this.x, this.y, null);
        }

        move();
    }

    /*
     * @Description //ensure direction
     * @Param [e]
     * @return void
     **/
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                bUp = true;
                break;
            case KeyEvent.VK_DOWN:
                bDown = true;
                break;
            case KeyEvent.VK_LEFT:
                bLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                bRight = true;
                break;
        }

        setMainDir();
    }

    /*
     * @Description //ensure direction
     * @Param [e]
     * @return void
     **/
    public void keReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:
                bUp = false;
                break;
            case KeyEvent.VK_DOWN:
                bDown = false;
                break;
            case KeyEvent.VK_LEFT:
                bLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                bRight = false;
                break;
            case KeyEvent.VK_W:
                fire();
                break;
            case KeyEvent.VK_A:
                PropertyManager.set("strategy","DefaultFireStrategy");
                break;
            case KeyEvent.VK_S:
                PropertyManager.set("strategy","FourDirFireStrategy");
                break;
            case KeyEvent.VK_D:
                PropertyManager.set("strategy","TwoDirFireLRStrategy");
                break;
            case KeyEvent.VK_F:
                PropertyManager.set("strategy","TwoDirFireUDStrategy");
                break;
        }

        setMainDir();
    }

    /*
     * @Description //set tank direction
     * @Param []
     * @return void
     **/
    private void setMainDir() {
//        all direction keys are released, tank should be stop.
        if(!bUp && !bDown && !bLeft && !bRight)
            moving = false;
//        any direction keys are pressed, tank should be moving.
        else {
            moving = true;
            if (bUp && !bDown && !bLeft && !bRight)
                dir=Dir.UP;
            if (!bUp && bDown && !bLeft && !bRight)
                dir=Dir.DOWN;
            if (!bUp && !bDown && bLeft && !bRight)
                dir=Dir.LEFT;
            if (!bUp && !bDown && !bLeft && bRight)
                dir=Dir.RIGHT;
        }
    }

    /*
     * @Description //tank moving
     * @Param []
     * @return void
     **/
    public void move() {
        if ( !moving ) return;

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
    }

    private FireStrategy fireStrategy = null;

    private void intiFireStrategy(){
        String strategy = PropertyManager.get("strategy");
        ClassLoader loader = Player.class.getClassLoader();
        try {
//            Class clazz = Class.forName("com.mashibing.tank.v1.strategy."+strategy);
            Class clazz = loader.loadClass("com.itcast.tank.v1_singleten.strategy."+strategy);
            fireStrategy =  (FireStrategy)(clazz.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public void fire() {
        this.intiFireStrategy();

        fireStrategy.fire(this);
    }

    public void die() {
        this.setLive(false);
        TankFrameSingleton.INSTANCE.add( new Explode(x ,y));
    }

}
