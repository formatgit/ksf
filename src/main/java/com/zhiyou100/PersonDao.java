package com.zhiyou100;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonDao {

    Person findById(int id);

    Map findByIdToMap(int id);

    List<Person> findByName(@Param("name") String name, @Param("id") int id);
    List<Person> findByMap(Map params);


    int insert(Person person);

    int insertByMap(Map params);
}
