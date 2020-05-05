package com.itcast.tank.v9_Iterator.Iterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BulletIterator
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class ConcreteIterator<Landmine> implements Iterator<Landmine>, Serializable {

    private List<Landmine> list = new ArrayList<>();
    private int cursor = 0;
    private Landmine lm = null;



    public ConcreteIterator(List<Landmine> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public Landmine next() {
        if (this.hasNext()) {
            lm = this.list.get(cursor++);
        }
        return lm;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Landmine remove() {
        return list.remove(this.cursor);
    }

}
