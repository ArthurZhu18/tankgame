package com.itcast.tank.v10_decorator.Iterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ConcreteAggregate
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class ConcreteAggregate<Landmine> implements Aggregate<Landmine>, Serializable {

    private List<Landmine> list = new ArrayList<>();

    @Override
    public void add(Landmine obj) {
        list.add(obj);
    }

    @Override
    public void remove(Landmine obj) {
        list.remove(obj);
    }

    @Override
    public Iterator<Landmine> iterator() {
        return new ConcreteIterator(this.list);
    }

    @Override
    public int size() {
        return list.size();
    }
}
