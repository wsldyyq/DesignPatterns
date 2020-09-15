package org.singleton.staticinnerclass;

/**
 * 静态内部类单例模式
 *
 * 静态内部类加载过程 -> 仅在第一次被调用时才会加载
 * 此种懒汉单例模式巧妙运用了Java类的加载机制
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
        //在构造函数中加入判断，防止使用反射的暴力方式直接创建实例
        if (SingletonClass.INSTANCE != null) {
            throw new RuntimeException("不允许非法访问");
        }
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonClass.INSTANCE;
    }

    private static class SingletonClass {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
}
