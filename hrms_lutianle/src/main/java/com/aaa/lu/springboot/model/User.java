package com.aaa.lu.springboot.model;

import lombok.Data;
import lombok.Generated;

import java.io.Serializable;

@Data
@Generated
public class User implements Serializable {
    private Integer userid;

    private String username;

    private Integer deptid;

    private String email;

    private String phonenum;

    private Integer status;

    private String password;

    private String salt;

    private Dept dept;



}