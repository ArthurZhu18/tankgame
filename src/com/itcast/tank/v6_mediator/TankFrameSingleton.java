package com.itcast.tank.v6_mediator;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

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

    private GameModel gm;

    Image offScreenImage = null;



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
    }

    /*
     * @Description //gain GameModel, add inner object, GameModel serve as Mediator
     * @Param []
     * @return com.mashibing.tank.v4_facade_Mediator.GameModel
     **/
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
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_C){
                save();
            }else if(key == KeyEvent.VK_V){
                load();
            }

            gm.getMyTank().keyPressed(e);
        }

        private void save() {
            ObjectOutputStream oos = null;
            try {
                File f = new File("d:/test/tank.dat");
                FileOutputStream fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(gm);
                oos.flush();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (oos!=null)
                        oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void load() {
            ObjectInputStream ois = null;
            try {
                File f = new File("d:/test/tank.dat");
                FileInputStream fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                gm = (GameModel) ois.readObject();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ois!=null)
                        ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gm.getMyTank().keReleased(e);
        }
    }
}