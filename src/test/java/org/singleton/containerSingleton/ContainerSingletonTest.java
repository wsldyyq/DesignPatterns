package org.singleton.containerSingleton;

import junit.framework.TestCase;
import org.junit.Test;

public class ContainerSingletonTest extends TestCase {

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                Object instance = ContainerSingleton.getInstance("org.singleton.containerSingleton.ContainerSingleton");
                System.out.println(instance);
            }).start();
        }
    }
}