package org.java.login.service;

import org.java.login.pojo.LoginPojo;

public interface LoginService {
    /**
     * 查询用户名和密码
     * @param username
     * @param password
     * @return
     */
    public LoginPojo queryUser(String username, String password);


    /**
     * 用户注册的方法
     * @param customer
     * @return
     */
    public Boolean registerUser(LoginPojo customer);
}
