package com.itcast.tank.v10_decorator;

import com.itcast.tank.v10_decorator.command.Receiver;
import com.itcast.tank.v10_decorator.command.Command;
import com.itcast.tank.v10_decorator.command.Invoker;
import com.itcast.tank.v10_decorator.command.KeyPressedCommandImpl;
import com.itcast.tank.v10_decorator.decorator.Grass;
import com.itcast.tank.v10_decorator.decorator.WallImpl;

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
    public static final TankFrameSingleton INSTANCE = new TankFrameSingleton();

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private static GameModel gm;

    Image offScreenImage = null;

    private Receiver receiver;
    private Command cmd;
    private Invoker invoker;



    /*
     * @Description //only self can be create self, using singleton pattern
     * @Param []
     * @return
     **/
    private TankFrameSingleton(){
        this.setTitle("Tank war");
        this.setLocation(400,100);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

        this.addKeyListener(new TankKeyListener());

        gm = new GameModel();

        receiver = new Receiver();
        cmd = new KeyPressedCommandImpl(receiver);
        invoker = new Invoker(cmd);
    }

    /*
     * @Description //gain GameModel, add inner object, GameModel serve as Mediator
     * @Param []
     * @return com.mashibing.tank.v4_facade_Mediator.GameModel
     **/
    public static GameModel getGm() {
        return gm;
    }

    public static void setGm(GameModel gameModel){
        gm = gameModel;
    }

    /*
     * @Description //painting，awt system automatic calling
     * painting all objects
     * @Param [g]
     * @return void
     **/
    @Override
    public void paint(Graphics g) {//Graphics g painting tool
        new Grass(new WallImpl(100,100,100,100)).paint(g);
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
            /*int key = e.getKeyCode();
            if (key == KeyEvent.VK_C){
                save();
            }else if(key == KeyEvent.VK_V){
                load();
            }*/
            invoker.action(e);

            gm.getMyTank().keyPressed(e);
        }



        @Override
        public void keyReleased(KeyEvent e) {
            gm.getMyTank().keReleased(e);
        }
    }
}