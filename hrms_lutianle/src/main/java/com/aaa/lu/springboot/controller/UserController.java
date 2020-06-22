package com.aaa.lu.springboot.controller;


import com.aaa.lu.springboot.model.User;
import com.aaa.lu.springboot.service.UserService;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ltl
 * @Date 2020/6/19  9:14
 * @Description
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/queryAllUser")
    public List<User> queryAll(){
        return userService.queryAll();
    }

    @PostMapping("/addUser")
    public String addUser(User user){
       int result= userService.addUser(user);
        return "userList";
    }
    @PostMapping("/queryById")
    public List<User> queryById(Integer id){
        List<User> list = new ArrayList<>();
        list.add(userService.queryById(id));
       return list;
    }


    @PostMapping("/queryByUserName")
    public List<User> queryByUserName(String username){
        return userService.queryByUserName(username);
    }

    @PostMapping("/deleteById")
    public int deleteById(Integer userid){
        return userService.deleteById(userid);
    }



}
