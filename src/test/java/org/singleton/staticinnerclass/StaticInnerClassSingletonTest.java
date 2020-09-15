package org.singleton.staticinnerclass;

import junit.framework.TestCase;
import org.junit.Test;

public class StaticInnerClassSingletonTest extends TestCase {
    @Test
    public void test() {
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        System.out.println(instance);
    }
}