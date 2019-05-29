package com.ley.mybatis.learn.mapper;

import com.ley.mybatis.learn.bo.UserQueryBO;
import com.ley.mybatis.learn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(@Param("userId") String userId);

    List<User> getUsersByMap(Map<String, Object> params);

    List<User> getUsersByAnnotation(@Param("userName") String userName, @Param("userAge") Integer age);

    List<User> getUsersByBO(UserQueryBO userQueryBO);

    List<User> getUserByUserName(@Param("userName") String userName);


    List<User> getUserByCondition(UserQueryBO userQueryBO);
}
