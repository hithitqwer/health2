package com.creator.mapper;

import com.creator.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    int countNumOfUser();

    void insert(User user);

    User selectByName(String name);

    User selectById(int userId);
}
