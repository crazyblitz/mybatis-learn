package com.ley.mybatis.learn.mapper;

import com.ley.mybatis.learn.entity.IdCard;
import org.apache.ibatis.annotations.Param;

public interface IdCardMapper {

    IdCard getIdCardById(@Param("cardId") String cardId);
}
