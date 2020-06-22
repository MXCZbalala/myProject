package com.aaa.lu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/6/19  9:44
 * @Description
 **/
@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String UserList(){
        return "UserList";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "AddUser";
    }

    @RequestMapping("update")
    public String update(Integer id,Map map){
        map.put("userid",id);
        return "UserChange";
    }
}
