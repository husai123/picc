package org.java.userauth.service;

import org.java.insurance.userauth.pojo.UserInfo;
import org.java.insurance.userauth.utils.JwtUtils;
import org.java.user.pojo.Employee;
import org.java.userauth.config.JwtProperties;
import org.java.userauth.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    private UserClient userClient;


    @Autowired
    private JwtProperties  jwtProperties;


    public String accredit(String username, String password) {
        Employee employee = userClient.queryUser(username, password);


        if (employee==null){
            return null;
        }

        //创建一个userInfo
        UserInfo userInfo=new UserInfo();

        userInfo.setId(userInfo.getId());
        userInfo.setUsername(userInfo.getUsername());


        String  token;

        try {
          token=JwtUtils.generateToken(userInfo,jwtProperties.getPrivateKey(),jwtProperties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }
}
