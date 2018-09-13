package com.zhiyou100.day02.cache;

import com.zhiyou100.day02.homework.Role;
import com.zhiyou100.day02.homework.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
*@ClassName:CacheTest
 @Description:TODO
 @Author:
 @Date:2018/9/6 10:21 
 @Version:v1.0
*/
public class CacheTest {
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
    public static void main(String[] args) {
        testFirstLevelCache();
    }
    //测试mybatis一级缓存
    private static void testFirstLevelCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        Role role1 = roleDao.findById(1);
        Role role2 = roleDao.findById(1);
        System.out.println(role1==role2);
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        RoleDao roleDao2 = sqlSession2.getMapper(RoleDao.class);
        Role role3 = roleDao2.findById(1);
        System.out.println(role3==role1);
    }

}
