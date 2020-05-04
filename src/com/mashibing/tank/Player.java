package com.mashibing.tank;

import com.mashibing.tank.strategy.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Player
 * @Description //player
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Player extends Tank {

    //ensure direction
    private boolean bUp, bDown, bLeft, bRight;
    //tank moving speed
    public static final int SPEED = 5;

    public Player(int x, int y, Dir dir) {
        super(x, y, dir);
        this.setGroup(Group.GOOD);
        this.setMoving(false);
    }


    /*
     * @Description //paint tank
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {
        if (!this.isLive()) return;

        switch (this.getDir()) {
            case UP:
                g.drawImage(ResourceManager.goodTankU, this.getX(), this.getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.goodTankD, this.getX(), this.getY(), null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.goodTankL, this.getX(), this.getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.goodTankR, this.getX(), this.getY(), null);
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
            setMoving(false);
//        any direction keys are pressed, tank should be moving.
        else {
            setMoving(true);
            if (bUp && !bDown && !bLeft && !bRight)
                setDir(Dir.UP);
            if (!bUp && bDown && !bLeft && !bRight)
                setDir(Dir.DOWN);
            if (!bUp && !bDown && bLeft && !bRight)
                setDir(Dir.LEFT);
            if (!bUp && !bDown && !bLeft && bRight)
                setDir(Dir.RIGHT);
        }
    }

    /*
     * @Description //tank moving
     * @Param []
     * @return void
     **/
    public void move() {
        if ( !isMoving() ) return;

        switch (getDir()){
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
    }

    private FireStrategy fireStrategy = null;

    private void intiFireStrategy(){
        String strategy = PropertyManager.get("strategy");
        ClassLoader loader = Player.class.getClassLoader();
        try {
//            Class clazz = Class.forName("com.mashibing.tank.strategy."+strategy);
            Class clazz = loader.loadClass("com.mashibing.tank.strategy."+strategy);
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


    @Override
    public void fire() {
        this.intiFireStrategy();
        fireStrategy.fire(this);
    }

}
