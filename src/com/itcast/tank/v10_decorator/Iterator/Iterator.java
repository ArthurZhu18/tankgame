package com.itcast.tank.v10_decorator.Iterator;

import java.io.Serializable;

/**
 * @ClassName Iterator
 * @Description TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Iterator<Landmine> extends Serializable {
    boolean hasNext();
    Landmine next();
    int size();
    Landmine remove();
}
