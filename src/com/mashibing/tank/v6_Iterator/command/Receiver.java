package com.mashibing.tank.v6_Iterator.command;

import com.mashibing.tank.v6_Iterator.GameModel;
import com.mashibing.tank.v6_Iterator.TankFrameSingleton;

import java.awt.event.KeyEvent;
import java.io.*;

/**
 * @ClassName Receiver
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Receiver {

    public void action(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_C){
            save();
        }else if(key == KeyEvent.VK_V){
            load();
        }
    }

    private void save() {
        ObjectOutputStream oos = null;
        try {
            File f = new File("d:/test/tank.dat");
            FileOutputStream fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(TankFrameSingleton.getGm());
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
            TankFrameSingleton.setGm((GameModel) ois.readObject());

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

}
