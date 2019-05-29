package com.ley.mybatis.learn.proxy;


import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class CglibProxy implements MethodInterceptor {


    public Object getProxy(Class<?> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallbacks(new Callback[]{this, NoOp.INSTANCE});
        enhancer.setCallbackFilter(method -> {
            if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
                return 0;
            } else {
                return 1;
            }
        });
        enhancer.setNamingPolicy(MybatisNamingPolicy.INSTANCE);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }
}
