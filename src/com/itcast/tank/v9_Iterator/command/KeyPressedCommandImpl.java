package com.itcast.tank.v9_Iterator.command;

import java.awt.event.KeyEvent;

/**
 * @ClassName KeyPressedCommandImpl
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class KeyPressedCommandImpl implements Command {

    private Receiver receiver;

    public KeyPressedCommandImpl(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute(KeyEvent keyEvent) {
        receiver.action(keyEvent);
    }
}
