package com.aaa.lu.springboot.mapper;

import com.aaa.lu.springboot.model.Dept;
import com.aaa.lu.springboot.model.User;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> queryAllDept();
}