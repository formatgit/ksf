package com.zhiyou100.day02.homework;

import lombok.Data;

import java.util.List;

/*
*@ClassName:Permission
 @Description:TODO
 @Author:
 @Date:2018/9/6 8:36 
 @Version:v1.0
*/
@Data
public class Permission {
    private int id;
    private String name;
    private List<Role> roles;
}
