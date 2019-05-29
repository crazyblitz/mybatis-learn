package com.ley.mybatis.learn.proxy;

public class SayHello {

    public void say1() {
        say4();
        System.out.println("say1 public");
    }

    protected void say4() {
        System.out.println("say4 inner");
    }

    public final void say2() {
        System.out.println("say2 public final");
    }

    public static void say3() {
        System.out.println("say3 public static");
    }
}
