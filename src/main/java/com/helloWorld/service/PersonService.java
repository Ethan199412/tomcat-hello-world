package com.helloWorld.service;

import com.google.gson.Gson;
import com.helloWorld.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class PersonService {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public PersonService(){
        this.init();
    }

    public void init(){
        try {
            String resource = "config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            this.sqlSession = sqlSessionFactory.openSession();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public List<User> getAll(){
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(new Gson().toJson(users));
        return users;
    }
}
