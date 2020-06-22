package com.aaa.lu.springboot.controller;

import com.aaa.lu.springboot.model.Dept;
import com.aaa.lu.springboot.model.User;
import com.aaa.lu.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/6/19  10:52
 * @Description
 **/
@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/queryAllDept")
    @ResponseBody
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }
}
