package com.itcast.tank.v10_decorator.command;

import java.awt.event.KeyEvent;

/**
 * @ClassName Command
 * @Description TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public interface Command {
    void execute(KeyEvent keyEvent);
}
