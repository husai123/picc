package org.java.customer.web;


import org.java.customer.pojo.Employee;
import org.java.customer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * 员工登录注册
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 检查，用户名与电话号码是否可用
     * 可用返回true,不可用返回false
     * @param data---要验证的数据
     * @param type --1:验证用户名，  2：验证手机号
     * @return
     * 测试地址：
     *  直接访问: localhost:14000/employee/check?data=jack&type=1
     */
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkData(@RequestParam("data") String data, @RequestParam("type") Integer type){

        //判断是否可用
        Boolean flag = employeeService.checkData(data,type);
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
     * @param employee
     * @return
     * 直接访问地址：localhost:14000/employee/register?xx=xx,请求方式为post
     * 网关访问地址: http://api.insurance.com/api/customer/employee/register
     */
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(Employee employee){

        //注册新用户，成功返回true,失败返回false
        Boolean flag = employeeService.registerUser(employee);

        if(flag==false){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



    /**
     * 接收用户名，密码，判断是否可以查询到数据
     * @param username
     * @param password
     * @return
     * localhost:14000/employee/query?username=xx&password=x
     */
    @GetMapping("/query")
    public ResponseEntity<Employee> queryUser(@RequestParam("username") String username,@RequestParam("password") String password){

        Employee employee = employeeService.queryUser(username,password);

        if(employee==null){
            //表示用户名不存在，或者是密码错误
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employee);
    }


}
