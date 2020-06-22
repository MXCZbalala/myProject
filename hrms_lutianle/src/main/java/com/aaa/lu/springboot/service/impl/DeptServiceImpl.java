package com.aaa.lu.springboot.service.impl;

import com.aaa.lu.springboot.mapper.DeptMapper;
import com.aaa.lu.springboot.model.Dept;
import com.aaa.lu.springboot.model.User;
import com.aaa.lu.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/6/19  9:16
 * @Description
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> queryAllDept() {
        return deptMapper.queryAllDept();
    }
}
