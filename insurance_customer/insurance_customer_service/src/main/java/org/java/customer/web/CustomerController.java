package org.java.customer.web;

import org.java.customer.pojo.Customer;
import org.java.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 检查，邮箱与电话号码是否可用用
     * 可用返回true,不可用返回false
     * @param data---要验证的数据
     * @param type --1:验证邮箱，  2：验证手机号
     * @return
     * 测试地址：
     *  直接访问: localhost:14000/user/check?data=jack&type=1
     */
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkData(@RequestParam("data") String data, @RequestParam("type") Integer type){

        //判断是否可用
        Boolean flag = customerService.checkData(data,type);
        if(flag==null){
            //如果返回null，表示数据格式错误
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //上面的代码，可以简写为
            return ResponseEntity.badRequest().build();
        }
        //return ResponseEntity.status(HttpStatus.OK).body(flag);
        return ResponseEntity.ok(flag);
    }


    /**
     * 用户注册
     * @param customer
     * @return
     * 直接访问地址：localhost:14000/user/register?xx=xx,请求方式为post
     * 网关访问地址: api.shopping.com/api/customer/register/xxxx
     */
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid Customer customer){

        System.out.println("进来了");
        //注册新用户，成功返回true,失败返回false
        Boolean flag = customerService.registerUser(customer);
        if(flag==false){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     * 接收电话号码或电子邮箱，密码，判断是否可以查询到数据
     * @param date
     * @param password
     * @return
     * localhost:14000/user/query?username=xx&password=x
     */
    @GetMapping("/query")
    public ResponseEntity<Customer> queryUser(@RequestParam("date") String date,@RequestParam("password") String password){

        Customer customer = customerService.queryUser(date,password);

        if(customer==null){
            //表示用户名不存在，或者是密码错误
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/queryCustomerById/{id}")
    public ResponseEntity<Customer> queryCustomerById(@PathVariable("id") String id){
        Customer customer = customerService.queryCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }



    @GetMapping("/byuserId/{id}")
    public ResponseEntity<Customer> queryUserById(@PathVariable("id") String id){
        Customer cus = customerService.queryCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cus);
    }
    @PutMapping("/updatePwd/{uname}/{pwd}")
    public ResponseEntity<Void> updatePwd(@PathVariable("uname")String uname,@PathVariable("pwd")String pwd){
        customerService.updatePwd(uname,pwd);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/updateInfo/{id}/{uname}/{phone}/{email}")
    public ResponseEntity<Void> updateInfo(@PathVariable("id")String id,@PathVariable("uname")String uname,@PathVariable("phone")String phone,@PathVariable("email")String email){
        customerService.updateInfo(id,phone,email,uname);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/updatePhone/{id}/{a}/{b}/{img}")
    public ResponseEntity<Void> updatePhone(@PathVariable("id")String id,@PathVariable("a")String a,@PathVariable("b")String b,@PathVariable("img")String img){
        customerService.updatePhone(id,img);
        return ResponseEntity.ok().build();
    }
}
