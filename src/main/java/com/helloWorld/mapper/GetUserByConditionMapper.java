package com.helloWorld.mapper;

import com.helloWorld.entity.User;

import java.util.List;

public interface GetUserByConditionMapper {
    List<User> selectByCondition(User user);
}
