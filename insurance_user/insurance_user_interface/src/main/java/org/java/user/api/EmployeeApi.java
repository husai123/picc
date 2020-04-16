package org.java.user.api;

import org.java.user.pojo.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeApi {


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/employee/query")
    public Employee queryUser(@RequestParam("username") String username,
                              @RequestParam("password") String password);

}

