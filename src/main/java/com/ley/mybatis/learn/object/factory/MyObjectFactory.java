package com.ley.mybatis.learn.object.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

@Slf4j
public class MyObjectFactory extends DefaultObjectFactory {

    @Override
    public void setProperties(Properties properties) {
        log.info("定制属性: {}", properties);
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        T result = super.create(type);
        log.info("使用对象工厂定制单个对象: {}", result);
        return result;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        log.info("使用对象工厂定制列表对象: {}", result);
        return result;
    }


    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
