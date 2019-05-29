package com.ley.mybatis.learn;

import com.ley.mybatis.learn.bo.UserQueryBO;
import com.ley.mybatis.learn.mapper.IdCardMapper;
import com.ley.mybatis.learn.mapper.UserMapper;
import com.ley.mybatis.learn.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {

    @Test
    public void testMybatis() {
        try {
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            IdCardMapper mapper = sqlSession.getMapper(IdCardMapper.class);
            System.out.println(mapper.getIdCardById("3763d4ba-2f85-40f1-ba7e-edba86297ef7"));
        } finally {
            SqlSessionUtils.closeSqlSession();
        }
    }


    @Test
    public void testDynamicSQLIf() {
        try {
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            String userName = "刘";
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.getUserByUserName(userName));
        } finally {
            SqlSessionUtils.closeSqlSession();
        }
    }

    @Test
    public void testDynamicSQLChooseWhen() {
        try {
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            UserQueryBO userQueryBO = new UserQueryBO();
            String userName = "刘恩源6";
            userQueryBO.setUserName(userName);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.getUserByCondition(userQueryBO).size());

            int userAge = 25;
            userQueryBO.setUserAge(userAge);
            userQueryBO.setUserName("");
            System.out.println(mapper.getUserByCondition(userQueryBO).size());

            userQueryBO = new UserQueryBO();
            System.out.println(mapper.getUserByCondition(userQueryBO).size());
        } finally {
            SqlSessionUtils.closeSqlSession();
        }
    }
}
