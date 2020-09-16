package org.singleton.containerSingleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例(Spring IoC容器)
 * @author guzl
 * @description
 * @date 2020/9/16
 */
public class ContainerSingleton {
    private static ConcurrentHashMap<String, Object> objectMap = new ConcurrentHashMap<>();

    private ContainerSingleton() {
    }

    public static Object getInstance(String className) {
        if (!objectMap.containsKey(className)) {
            //同步锁保证线程安全
            synchronized (ContainerSingleton.class) {
                //双重检查
                if (!objectMap.containsKey(className)) {
                    Object instance;
                    try {
                        instance = Class.forName(className).newInstance();
                        objectMap.put(className, instance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return objectMap.get(className);
    }
}
