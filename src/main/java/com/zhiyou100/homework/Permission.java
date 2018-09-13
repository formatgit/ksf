package com.zhiyou100.homework;

import lombok.Data;

import java.util.List;

/*
*@ClassName:Permission
 @Description:TODO
 @Author:
 @Date:2018/9/5 16:48 
 @Version:v1.0
*/
@Data
public class Permission {
    private int id;
    private String name;
    private List<Role> roleList;
}
