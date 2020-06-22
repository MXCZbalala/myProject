package com.aaa.lu.springboot.mapper;

import com.aaa.lu.springboot.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryAllUser();

    List<User> queryByUserName(String string);

    @Select("select * from tb_user where username=#{username}")
    User findUserByName(String username);

}