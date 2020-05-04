package com.mashibing.tank.v4_facade_Mediator;

import com.mashibing.tank.v4_facade_Mediator.chainofresponsibility.ColliderChain;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GameModel
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class GameModel implements Serializable {
    private Player myTank;

    private List<AbstractGameObject> objects;

    ColliderChain chain;

    public GameModel() {
        intiGameObjects();
    }

    public Player getMyTank() {
        return myTank;
    }

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
     * @Description while user pressed control key,
     * fire() in Tank class invoking this function add(),
     * add bullet in bullets
     * @Param [go]
     * @return void
     **/
    public void add(AbstractGameObject go){
        objects.add(go);
    }

    /*
     * @Description //painting all Objects in Model
     * @Param [g]
     * @return void
     **/
    public void paint(Graphics g){
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
        }

        for (int i = 0; i < objects.size(); i++) {

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




}
