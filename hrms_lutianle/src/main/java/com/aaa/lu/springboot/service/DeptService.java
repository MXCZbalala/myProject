package com.aaa.lu.springboot.service;

import com.aaa.lu.springboot.model.Dept;
import com.aaa.lu.springboot.model.User;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/6/19  9:15
 * @Description
 **/
public interface DeptService {

    List<Dept> queryAllDept();
}
