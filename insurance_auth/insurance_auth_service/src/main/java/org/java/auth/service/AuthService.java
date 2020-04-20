package org.java.auth.service;

import org.java.auth.config.JwtProperties;
import org.java.auth.feign.UserClient;
import org.java.insurance.auth.pojo.UserInfo;
import org.java.customer.pojo.Customer;
import org.java.insurance.auth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties jwtProperties;

    //判断，用户信息是否正确，如果正确，就通过jwt生成token
    public String accredit(String date, String password) {

        //访问user-service的方法，判断用户信息
        Customer user = userClient.queryUser(date, password);;
        //判断对象是否为null,如果 为null,则信息不正确
        if (user == null) {
            return null;
        }

        //信息正确，就需要通过jwt的工具类，将信息封装成token
        //创建一个UserInfo作为载荷，返回结果
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getCust_id());
        userInfo.setUsername(user.getCust_truename());
        userInfo.setImg(user.getCust_head_img());
        String token;
        try {
            token = JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;

    }
}
