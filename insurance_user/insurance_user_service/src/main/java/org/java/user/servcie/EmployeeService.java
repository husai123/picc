package org.java.user.servcie;


import org.java.user.pojo.Employee;

public interface EmployeeService {


    Boolean checkData(String data, Integer type);

    Boolean registerUser(Employee employee);

    Employee queryUser(String username, String password);
    //修改信息
    public void updatePermissionPwd(String id,String uname,String phone);
    //修改密码
    public void updatePwd(String uname,String pwd);
}
