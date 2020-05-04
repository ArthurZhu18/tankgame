package com.mashibing.tank.v6_Iterator.command;

import java.awt.event.KeyEvent;

/**
 * @ClassName Invoker
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(KeyEvent e){
        command.execute(e);
    }

}
