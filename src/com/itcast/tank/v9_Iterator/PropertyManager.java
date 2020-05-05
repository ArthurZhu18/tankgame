package com.itcast.tank.v9_Iterator;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertyManager
 * @Description //TODO
 * @Author ArthurZhu
 * @Version 1.0
 */

public class PropertyManager {
    private static Properties props;

    static {
        try {
            props = new Properties();
            props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return (String)props.get(key);
    }

    public static void set(String key, String value){
        props.setProperty(key,value);
    }

}
