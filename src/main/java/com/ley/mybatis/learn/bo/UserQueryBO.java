package com.ley.mybatis.learn.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryBO {

    private String userName;

    private Integer userAge;
}
