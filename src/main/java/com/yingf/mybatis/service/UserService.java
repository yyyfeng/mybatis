package com.yingf.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingf.mybatis.mapper.UserMapper;
import com.yingf.mybatis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public PageInfo<User> selectByPage(int page,int pageSize,String name){
        PageHelper.startPage(page,pageSize);
        List<User> listUser=userMapper.selectByPage(name);
        //返回客户端进行展示
        PageInfo<User> pageInfo=new PageInfo<User>(listUser);
        return  pageInfo;
    }

    public  int insertUser(String name,int age){
        log.info("添加用户开始");
        int insertUserResult = userMapper.insertUser(name, age);
        log.info("############insertUserResult:{}###########",insertUserResult);
        if (insertUserResult==1){
            log.info("用户添加成功！");
        }else {
            log.info("用户添加失败！");
        }
        return  insertUserResult;
    }

    public int  selectByName(String name){
        User u = userMapper.selectByName(name);
        if (u==null){
            return 0;
        }else{
            return 1;
        }
    }
}
