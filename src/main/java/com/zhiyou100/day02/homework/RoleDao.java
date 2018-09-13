package com.zhiyou100.day02.homework;

import java.util.List;

/*
*@ClassName:RoleDao
 @Description:TODO
 @Author:
 @Date:2018/9/6 8:40 
 @Version:v1.0
*/
public interface RoleDao {
    Role findById(int id);
    List<Permission> findPermissionsById(int id);
}
