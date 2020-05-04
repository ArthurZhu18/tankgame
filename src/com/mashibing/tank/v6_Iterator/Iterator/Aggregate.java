package com.mashibing.tank.v6_Iterator.Iterator;

/**
 * @ClassName Aggregate
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Aggregate<Landmine> {
    void add(Landmine obj);
    void remove(Landmine obj);
    Iterator<Landmine> iterator();
    int size();

}
