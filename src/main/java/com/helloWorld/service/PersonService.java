package com.helloWorld.service;

import com.google.gson.Gson;
import com.helloWorld.entity.User;
import com.helloWorld.mapper.GetUserByConditionMapper;
import com.helloWorld.mapper.PersonInfoMapper;
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
            InputStream inputStream = Resources.getResourceAsStream("config.xml");
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            this.sqlSession = sqlSessionFactory.openSession();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public List<User> getAll(){
        this.init();
//        List<User> users = sqlSession.selectList("test.selectAll");

        PersonInfoMapper mapper = this.sqlSession.getMapper(PersonInfoMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(new Gson().toJson(users));
        this.sqlSession.close();
        return users;
    }

    public List<User> getUserByCondition(User user){
        this.init();
        GetUserByConditionMapper mapper = this.sqlSession.getMapper(GetUserByConditionMapper.class);
        List<User> users = mapper.selectByCondition(user);
        this.sqlSession.close();
        System.out.println("haha");
        return users;
    }
}
