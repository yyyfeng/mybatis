package com.yingf.mybatis.mapper;

import com.yingf.mybatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

//@Mapper 这个地方的mapper注解改为全局的@MapperScan注解，可以不用每次写mapper类的时候写mapper注解
@Component//将这个类交给Spring容器来管理 此处遗留问题，为什么课程里面可以使用Mapper注解，而此处不行
//@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{name}")
    User selectByName(@Param("name") String name);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int  insertUser(@Param("name") String name,@Param("age") int age);

    @Select("select * from user where name='' or name=#{name}")
    List<User> selectByPage(@Param("name") String name);

  }
