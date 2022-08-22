package com.helloWorld.mapper;

import com.helloWorld.entity.User;

import java.util.List;

public interface PersonInfoMapper {
    List<User> selectAll();
}
