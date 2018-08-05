package com.creator;

import com.creator.mapper.UserMapper;
import com.creator.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int countNumOfUser() {
        return userMapper.countNumOfUser();
    }

    @Override
    public User selectByName(String userName) {
        return userMapper.selectByName(userName);
    }

    @Override
    public User selectById(int userId) {
        return userMapper.selectById(userId);
    }
}
