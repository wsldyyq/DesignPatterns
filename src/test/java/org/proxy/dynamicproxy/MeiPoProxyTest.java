package org.proxy.dynamicproxy;

import junit.framework.TestCase;
import org.junit.Test;

public class MeiPoProxyTest extends TestCase {

    @Test
    public void test() {
        MeiPoProxy meiPoProxy = new MeiPoProxy();
        IPerson zhangsanProxy = meiPoProxy.getInstance(new Zhangsan());
        zhangsanProxy.findLove("Lily");
    }
}