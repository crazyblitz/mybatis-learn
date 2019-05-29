package com.ley.mybatis.learn.proxy;

import org.springframework.cglib.core.DefaultNamingPolicy;

public class MybatisNamingPolicy extends DefaultNamingPolicy {

    public static final MybatisNamingPolicy INSTANCE = new MybatisNamingPolicy();

    @Override
    protected String getTag() {
        return "ByMybatisCGLIB";
    }
}
