package com.itcast.tank.v1_singleten;

import com.itcast.tank.v1_singleten.chainofresponsibility.ColliderChain;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.mashibing.tank.TankFrame
 * @Description //the game frame
 * @Author ArthurZhu
 * @Version 1.0
 */

public class TankFrameSingleton extends Frame {
    //单例模式
    public static final TankFrameSingleton INSTANCE = new TankFrameSingleton();

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    Image offScreenImage = null;
    private Player myTank;

    private List<AbstractGameObject> objects;

    ColliderChain chain;


    /*
     * @Description //only self can be create self, using singleton pattern
     * @Param []
     * @return
     **/
    private TankFrameSingleton(){
        //设置窗口标题
        this.setTitle("Tank war");
        //设置窗口显示位置
        this.setLocation(400,100);
        //设置窗口大小
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

        //为窗口添加键盘观察者
        this.addKeyListener(new TankKeyListener());

        intiGameObjects();


    }



    /*
     * @Description //initialize Game Objects
     * @Param []
     * @return void
     **/
    private void intiGameObjects() {
        myTank = new Player(400, 500, Dir.UP);

        objects = new ArrayList<>();
        chain = new ColliderChain();

        int tankCount = Integer.parseInt(PropertyManager.get("initNPCTankCount"));

        for (int i = 0; i < tankCount; i++) {
            objects.add(new NPC(100+i*100, 100, Dir.DOWN));
        }

        this.add(new Wall(300,200,100,30));

    }

    /*
     * @Description //while user pressed control key,
     * fire() in Tank class invoking this function add(),
     * add bullet in bullets
     * @Param [go]
     * @return void
     **/
    public void add(AbstractGameObject go){
        objects.add(go);
    }


    /*
     * @Description //painting，awt system automatic calling
     * painting all objects
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {//Graphics g painting tool


        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("objects:"+objects.size(), 10, 50);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {

            if (!objects.get(i).isLive()) {
                objects.remove(i);
                break;
            }

            AbstractGameObject go1 = objects.get(i);
            for (int j = 0; j < objects.size(); j++) {
                AbstractGameObject go2 = objects.get(j);

                chain.collide(go1, go2);

            }

            if (objects.get(i).isLive()) {
                objects.get(i).paint(g);
            }
        }


    }


    /*
     * @Description //use double buffering resolve flicker problem
     * @Param [g]
     * @return void
     **/

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /*
     * @Description //observer --- observe keyboard response event
     * @Param
     * @return
     **/
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keReleased(e);
        }
    }
}