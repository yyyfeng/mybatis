package com.yingf.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.yingf.mybatis.pojo.User;
import com.yingf.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("selectByPage" )
    public PageInfo<User> selectByPage(int page,int pageSize,String name){
        PageInfo<User> userPageInfo = userService.selectByPage(page, pageSize,name);
        return userPageInfo;
    }
    @Transactional//添加事务的注解，解决用户添加失败的注解
    @RequestMapping(value = "insertUser",method = RequestMethod.GET)
    public String  insertUser(String name,Integer age){
        int selectUserResult = userService.selectByName(name);
        if (selectUserResult==1) {
            return "该用户名已经存在！";
        }
        int insertUserResult = userService.insertUser(name, age);
        if(insertUserResult==1){
            return "SUCCESS";
        }else{
            return "ERROR";
        }

    }
}
