package com.itcast.tank.v2_observer.chainofresponsibility;

import com.itcast.tank.v2_observer.AbstractGameObject;
import com.itcast.tank.v2_observer.PropertyManager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ColliderChain
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class ColliderChain implements Collider {
    private List<Collider> colliders;

    public ColliderChain(){
        intiColliders();
    }

    private void intiColliders() {
        colliders = new ArrayList<>();
        String[] collidersNames = PropertyManager.get("colliders").split(",");
        try {
            for (String name : collidersNames) {
                Class clazz = Class.forName("com.itcast.tank.v2_observer.chainofresponsibility."+ name);
                Collider c = (Collider) clazz.getConstructor().newInstance();
                colliders.add(c);
            }
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

    public boolean collide(AbstractGameObject go1, AbstractGameObject go2){
        for (Collider collider : colliders) {
            if(!collider.collide(go1,go2)){
                return false;
            }
        }
        return true;
    }

}
