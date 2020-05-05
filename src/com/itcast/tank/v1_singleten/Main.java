package com.itcast.tank.v1_singleten;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName com.mashibing.tank.v1.Main
 * @Description //main program
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Main {

    public static void main(String[] args) {

        //visible frame
        TankFrameSingleton.INSTANCE.setVisible(true);

        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        for (;;) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);//sleep 35 milliseconds  1s = 40frame
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //repaint frame   repaint()-->update()-->paint()
            TankFrameSingleton.INSTANCE.repaint();
        }
    }

}
