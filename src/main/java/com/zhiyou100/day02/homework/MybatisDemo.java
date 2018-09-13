package com.zhiyou100.day02.homework;

import com.zhiyou100.*;
import com.zhiyou100.homework.Role;
import com.zhiyou100.homework.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*@ClassName:MybatisDemo
 @Description:TODO
 @Author:
 @Date:2018/9/4 16:23 
 @Version:v1.0
*/
public class MybatisDemo {

    public static SqlSessionFactory sqlSessionFactory;


    static {
        String resource = "mybatis-config.xml";
        //创建一个sqlsessionFactory对象  用来获取sqlsession
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {


        //testSelect();
        //testInsert();
        //testSelectMore();
       // testSelectMap();
        //testResultMap();
       // testInsertMap();
        //testSelectByMap();
        //testManyToOne();
        //testOneToMany();
        testManyToMany();
    }

    private static void testManyToMany() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        com.zhiyou100.day02.homework.RoleDao roleDao = sqlSession.getMapper(com.zhiyou100.day02.homework.RoleDao.class);
        com.zhiyou100.day02.homework.Role role = roleDao.findById(1);
        System.out.println(role);
        List<Permission> permissionList = roleDao.findPermissionsById(1);
        System.out.println(permissionList);
    }

    private static void testOneToMany() {
        SqlSession session = sqlSessionFactory.openSession();
        GradeDao gradeDao = session.getMapper(GradeDao.class);
        Grade grade = gradeDao.findById(1);
        System.out.println(grade);

    }

    private static void testManyToOne() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findById(1);
        //student.getGrade().getName();
        System.out.println(student);
    }

    private static void testSelectByMap() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Map<Object, Object> map = new HashMap();
        map.put("abc",1);
        map.put("name","tom");
        List<Person> personList = personDao.findByMap(map);
        System.out.println(personList);
    }

    private static void testInsertMap() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",2019);
        map.put("name","dle");
        personDao.insertByMap(map);
        session.commit();
        session.close();
        //System.out.println(person);
    }

    private static void testResultMap() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Person person = personDao.findById(1);
        System.out.println(person);
    }

    private static void testSelectMap() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        Map map = personDao.findByIdToMap(1);
        System.out.println(map);
    }

    private static void testSelectMore() {
        long start = System.currentTimeMillis();
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        List<Person> personList = personDao.findByName("tom",1);
        System.out.println(personList.size());
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

    private static void testInsert() {

        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        personDao.insert(new Person(1, "12"));
    }

    private static void testSelect() {
        SqlSession session = sqlSessionFactory.openSession();
        //获取mapper mapper 是dao的实现
        PersonDao personDao = session.getMapper(PersonDao.class);
        personDao.findById(1);

    }
}
