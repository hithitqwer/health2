package com.creator;

import com.creator.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int countNumOfUser()
    {
        return userMapper.countNumOfUser();
    }
}
