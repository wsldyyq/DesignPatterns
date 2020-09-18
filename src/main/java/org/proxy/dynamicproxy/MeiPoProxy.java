package org.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
public class MeiPoProxy implements InvocationHandler {

    private IPerson person;

    public IPerson getInstance(IPerson person) {
        this.person = person;
        return (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy method start");
        for (Object arg : args) {
            System.out.println(arg);
        }
        method.invoke(this.person, args);
        System.out.println("proxy method end");
        return person;
    }

    public static void main(String[] args) {
        MeiPoProxy meiPoProxy = new MeiPoProxy();
        IPerson zhangsanProxy = meiPoProxy.getInstance(new Zhangsan());
        zhangsanProxy.findLove("Lily");
    }
}
