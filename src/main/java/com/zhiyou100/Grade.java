package com.zhiyou100;

import lombok.Data;

import java.util.List;

/*
*@ClassName:Grade
 @Description:TODO
 @Author:
 @Date:2018/9/5 15:00 
 @Version:v1.0
*/
@Data
public class Grade {
    private int id;
    private String name;
    /*表示一对多*/
    private List<Student> studentList;
}
