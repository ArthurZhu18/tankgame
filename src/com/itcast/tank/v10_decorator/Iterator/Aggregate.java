package com.itcast.tank.v10_decorator.Iterator;

import java.io.Serializable;

/**
 * @ClassName Aggregate
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Aggregate<Landmine> extends Serializable {
    void add(Landmine obj);
    void remove(Landmine obj);
    Iterator<Landmine> iterator();
    int size();

}
