package com.ley.mybatis.learn.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
public class SqlSessionFactoryUtils {


    private static final String CONFIG_LOCATION = "mybatis-config.xml";

    public static SqlSessionFactory getInstance() {
        return SqlSessionFactoryHolder.sqlSessionFactory;
    }


    private static class SqlSessionFactoryHolder {


        private static SqlSessionFactory sqlSessionFactory = null;

        static {
            ClassPathResource configResource = new ClassPathResource(CONFIG_LOCATION);
            try {
                if (sqlSessionFactory == null) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource.getInputStream());
                }
            } catch (IOException e) {
                sqlSessionFactory = null;
                log.error("ex: {}", e);
            }
        }
    }

}
