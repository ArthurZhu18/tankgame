package com.mashibing.tank;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName com.mashibing.tank.Main
 * @Description //main program
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Main {

    public static void main(String[] args) {

        //visible frame
        TankFrame.INSTANCE.setVisible(true);

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        for (;;) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);//sleep 35 milliseconds  1s = 40frame
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //repaint frame   repaint()-->update()-->paint()
            TankFrame.INSTANCE.repaint();
        }
    }

}
