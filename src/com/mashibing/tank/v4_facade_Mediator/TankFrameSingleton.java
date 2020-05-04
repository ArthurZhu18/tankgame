package com.mashibing.tank.v4_facade_Mediator;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    private GameModel gm;

    Image offScreenImage = null;



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

        gm = new GameModel();
    }

    public GameModel getGm() {
        return gm;
    }

    /*
     * @Description //painting，awt system automatic calling
     * painting all objects
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {//Graphics g painting tool
        gm.paint(g);
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
     * @Description //observer pattern --- observe keyboard response event
     * @Param
     * @return
     **/
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            gm.getMyTank().keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gm.getMyTank().keReleased(e);
        }
    }
}