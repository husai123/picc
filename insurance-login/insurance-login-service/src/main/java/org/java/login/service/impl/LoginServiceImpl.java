package org.java.login.service.impl;


import org.java.login.dao.LoginMapper;
import org.java.login.pojo.LoginPojo;
import org.java.login.service.LoginService;
import org.java.login.util.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper loginMapper;


    /**
     *根据用户名与密码查询数据
     * @param username
     * @param password
     * @return
     */
    @Override
    public LoginPojo queryUser(String username, String password) {
        //创建一个User对象，封装查询条件
        LoginPojo recode = new LoginPojo();
        //根据查询条件查询对象
        recode.setUsername(username);

        LoginPojo user = loginMapper.selectOne(recode);

        if(user==null){
            return null;//用户名不存在
        }

        //从数据库，获得当前用户生成的盐
        String salt = user.getSalt();


        //比较用户输入的密码与数据库查询出来的密码是否一致
        //比较密码是否一致(对用户输入的密码，加盐，然后md5加密，得到一个结果，再与数据库的正确密码比较)
        if(!CodecUtils.md5Hex(password,salt).equals(user.getPassword())){
            return null;//密码错误
        }

        return user;//返回正确的数据


    }

    /**
     * 用户注册
     * @param loginPojo
     * @return
     */
    @Override
    public Boolean registerUser(LoginPojo loginPojo) {
//        //设置用户编号
//        loginPojo.setEmp_id(UUID.randomUUID().toString());

        //得到盐----------我们可以采用一个工具类生成盐
        String salt = CodecUtils.generateSalt();

        //对用户输入的密码进行MD5加密
        loginPojo.setPassword(CodecUtils.md5Hex(loginPojo.getPassword(),salt));

        //将盐设置到user中
        loginPojo.setSalt(salt);

        //受影响行数为 1 ，代表注册成功，方法返回true,反之为false
        return  loginMapper.insertSelective(loginPojo)==1;
    }
}
