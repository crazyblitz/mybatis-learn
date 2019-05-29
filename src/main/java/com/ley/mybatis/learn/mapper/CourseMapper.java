package com.ley.mybatis.learn.mapper;

import com.ley.mybatis.learn.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    List<Course> getCoursesByUserId(@Param("userId") String userId);
}
