package com.creator;

import com.creator.user.User;

public interface UserService {
    int countNumOfUser();

    User selectByName(String userName);

    User selectById(int userId);
}
