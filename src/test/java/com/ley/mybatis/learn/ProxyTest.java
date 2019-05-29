package com.ley.mybatis.learn;

import com.ley.mybatis.learn.proxy.CglibProxy;
import com.ley.mybatis.learn.proxy.SayHello;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void testCglibProxy() {
        CglibProxy proxy = new CglibProxy();
        SayHello proxyImpl = (SayHello) proxy.getProxy(SayHello.class);
        proxyImpl.say1();
        proxyImpl.say2();
        SayHello.say3();
        System.out.println(proxyImpl.getClass());
    }
}
