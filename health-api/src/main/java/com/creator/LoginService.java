package com.creator;

import com.creator.result.LoginResult;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    LoginResult login();

}
