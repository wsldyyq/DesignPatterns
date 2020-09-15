package org.singleton.doublecheck;

/**
 * 双重检查单例类
 * @author guzl
 * @description
 * @date 2020/9/15
 */
public class DoubleCheckSingleton {
    //volatile 防止指令重排序
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        //1.检查是否需要阻塞
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                //2.检查是否需要创建实例
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                    //指令重排序的解决
                }
            }
        }
        return instance;
    }
}
