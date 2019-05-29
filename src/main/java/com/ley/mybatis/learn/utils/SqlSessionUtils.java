package com.ley.mybatis.learn.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.util.Assert;


/**
 * SqlSession utility class
 *
 * @see org.apache.ibatis.session.SqlSession
 **/
@Slf4j
public class SqlSessionUtils {

    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = ThreadLocal.withInitial(() -> {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();
        Assert.notNull(sqlSessionFactory, "sqlSessionFactory must not null.");
        return sqlSessionFactory.openSession();
    });


    public static SqlSession getSqlSession() {
        return sqlSessionThreadLocal.get();
    }


    public static void closeSqlSession() {
        if (sqlSessionThreadLocal.get() != null) {
            SqlSession sqlSession = sqlSessionThreadLocal.get();
            sqlSession.close();
            sqlSessionThreadLocal.remove();
        }
    }
}
