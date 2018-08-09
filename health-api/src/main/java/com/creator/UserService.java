package com.creator;

import com.creator.model.user.User;

/**
 * @author zhangzeyu
 */
public interface UserService {
    int countNumOfUser();

    User selectByName(String userName);

    User selectById(int userId);
}
