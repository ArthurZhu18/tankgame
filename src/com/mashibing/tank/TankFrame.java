package com.mashibing.tank;

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

public class TankFrame extends Frame {
    //单例模式
    public static final TankFrame INSTANCE = new TankFrame();

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    Image offScreenImage = null;
    private Player myTank;

    private List<NPC> npcs;
    private List<Bullet> bullets;
    private List<Explode> explodes;

    /*
     * @Description //only self can be create self, using singleton pattern
     * @Param []
     * @return
     **/
    private TankFrame(){
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

    private void intiGameObjects() {
        myTank = new Player(400, 500, Dir.UP);

        bullets = new ArrayList<>();
        npcs = new ArrayList<>();
        explodes = new ArrayList<>();

        int tankCount = Integer.parseInt(PropertyManager.get("initNPCTankCount"));

        for (int i = 0; i < tankCount; i++) {
            npcs.add(new NPC(100+i*100, 100, Dir.DOWN));
        }

    }

    /*
     * @Description while user pressed control key,
     * fire() in Tank class invoking this function add(),
     * add bullet in bullets
     * @Param [bullet]
     * @return void
     **/
    public void add(Bullet bullet){
        this.bullets.add(bullet);
    }

    /*
     * @Description //painting，awt system automatic calling
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {//Graphics g painting tool

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullets:"+bullets.size(), 10, 50);
        g.drawString("npcs:"+npcs.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < npcs.size(); i++) {
            if (!npcs.get(i).isLive()){
                npcs.remove(i);
            }else {
                npcs.get(i).paint(g);
            }
        }

        for (int i = 0; i < bullets.size(); i++) {
            //myTank rank attack npcs
            for (int j = 0; j < npcs.size(); j++) {
                bullets.get(i).collidedWithTank(npcs.get(j));
            }

            //npcs tank attack myTank
            bullets.get(i).collidedWithTank(myTank);

            if (bullets.get(i).isLive()){
                bullets.remove(i);
            } else{
                bullets.get(i).paint(g);
            }
        }


        for (int i = 0; i < explodes.size(); i++) {
            if (!explodes.get(i).isLive()){
                explodes.remove(i);
            }else {
                explodes.get(i).paint(g);
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

    public void add(Explode explode) {
        this.explodes.add(explode);
    }

    /*
     * @Description //observer observe keyboard response event
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