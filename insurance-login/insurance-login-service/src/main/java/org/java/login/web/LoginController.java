package org.java.login.web;


import org.java.login.pojo.LoginPojo;
import org.java.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/login")
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * 接收用户名，密码，判断是否可以查询到数据
     * @param username
     * @param password
     * @return
     * localhost:15000/login/query?username=xx&password=x
     */
    @GetMapping("/query")
    public ResponseEntity<LoginPojo> queryUser(@RequestParam("username") String username,@RequestParam("password")String password){
        LoginPojo loginPojo=loginService.queryUser(username,password);

        if (loginPojo==null){
            //表示用户名不存在，或者是密码错误
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(loginPojo);
    }

    /**
     * 注册
     * @param user
     * @return
     * 直接访问地址：localhost:15000/login/register?xx=xx,请求方式为post
     */
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid LoginPojo user){

        //注册新用户，成功返回true,失败返回false
        Boolean flag = loginService.registerUser(user);
        if(flag==false){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
