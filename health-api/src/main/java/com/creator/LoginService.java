package com.creator;

import com.creator.result.LoginResult;

/**
 * @author zhangzeyu
 */
public interface LoginService {

    LoginResult login();

    Long getCodeByTime();
}
