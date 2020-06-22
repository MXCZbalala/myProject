package com.aaa.lu.springboot.service.impl;

import com.aaa.lu.springboot.mapper.UserMapper;
import com.aaa.lu.springboot.model.User;
import com.aaa.lu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ltl
 * @Date 2020/6/19  9:18
 * @Description
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> queryByUserName(String username) {
        return userMapper.queryByUserName(username);
    }

    @Override
    public int deleteById(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus(2);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public Set<String> findPermissionsByName(String username) {
        //模拟一个该用户对应的权限集合
        Set<String> set=new HashSet<>();
        //定义：资源:操作
        set.add("user:add");
        set.add("user:list");
        set.add("user:update");
        return set;
    }
}
