package org.singleton.doublecheck;

import junit.framework.TestCase;
import org.junit.Test;

public class DoubleCheckSingletonTest extends TestCase {




    @Test
    public void test() {
        new Thread(() -> {
            DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + instance);
        }).start();
        new Thread(() -> {
            DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + instance);
        }).start();
    }
}