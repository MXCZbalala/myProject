package com.aaa.lu.springboot.service;

import com.aaa.lu.springboot.model.User;

import java.util.List;
import java.util.Set;

/**
 * @Author ltl
 * @Date 2020/6/19  9:18
 * @Description
 **/
public interface UserService {

    User findUserByName(String username);

    List<User> queryAll();

    User queryById(Integer id);

    int addUser(User user);

    List<User> queryByUserName(String username);

    int deleteById(Integer id);
    Set<String> findPermissionsByName(String username);
}
