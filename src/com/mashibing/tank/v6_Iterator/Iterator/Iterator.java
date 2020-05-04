package com.mashibing.tank.v6_Iterator.Iterator;

import com.mashibing.tank.v5_command.Bullet;

/**
 * @ClassName Iterator
 * @Description TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Iterator<Landmine> {
    boolean hasNext();
    Landmine next();
    int size();
    Landmine remove();
}
