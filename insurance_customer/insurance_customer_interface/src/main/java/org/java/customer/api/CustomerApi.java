package org.java.customer.api;

import org.apache.ibatis.annotations.Param;
import org.java.customer.pojo.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerApi {

    /**
     * 用户登录验证
     * @param date       用户电话号码或电子邮箱
     * @param password   用户密码
     * @return
     */
    @GetMapping("/customer/query")
    public Customer queryUser(@RequestParam("date") String date,
                              @RequestParam("password") String password);

    @GetMapping("/customer/queryCustomerById/{id}")
    public Customer queryCustomerById(@PathVariable("id") @RequestParam("id") String id);

}
