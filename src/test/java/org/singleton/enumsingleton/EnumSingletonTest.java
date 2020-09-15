package org.singleton.enumsingleton;

import junit.framework.TestCase;
import org.junit.Test;

public class EnumSingletonTest extends TestCase {

    @Test
    public void test() {
        System.out.println(EnumSingleton.INSTANCE.hashCode());
        System.out.println(EnumSingleton.getInstance().hashCode());
    }
}