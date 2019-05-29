package com.ley.mybatis.learn.entity;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userId;
    private String userName;
    private Integer userAge;
    private IdCard idCard;
    private List<Course> courses;
}
