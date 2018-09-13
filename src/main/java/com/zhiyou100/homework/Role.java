package com.zhiyou100.homework;

import lombok.Data;

import java.util.List;

/*
*@ClassName:Role
 @Description:TODO
 @Author:
 @Date:2018/9/5 16:47 
 @Version:v1.0
*/
@Data
public class Role {
    private int id;
    private String name;
    private List<Permission> permissionList;
}
