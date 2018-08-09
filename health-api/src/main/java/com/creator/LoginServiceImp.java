package com.creator;

import com.creator.result.LoginResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangzeyu
 */
@Service
public class LoginServiceImp implements LoginService{
    @Override
    public LoginResult login()
    {
        return null;
    }

    @Override
    public Long getCodeByTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String code = sdf.format(date);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < code.length(); i++) {
            if(code.charAt(i) != '-') {
                sb.append(code.charAt(i));
            }
        }
        return Long.parseLong(sb.toString());
    }
}
