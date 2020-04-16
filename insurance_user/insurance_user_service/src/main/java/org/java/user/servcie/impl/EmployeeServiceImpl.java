package org.java.user.servcie.impl;



import org.java.user.mapper.EmployeeMapper;
import org.java.user.pojo.Employee;
import org.java.user.servcie.EmployeeService;
import org.java.user.util.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;




    /**
     * 检查数据是否可用，true:可用，false:不可用
     * @param data
     * @param type 它的值，只允许是1，2， 1：  2：用户名 手机号
     * @return
     */
    @Override
    public Boolean checkData(String data, Integer type) {

        //创建employee对象，封装查询数据
        Employee employeeUser=new Employee();

        if(type==1){
            employeeUser.setUsername(data);//按用户名查询
        }else if(type==2){
            employeeUser.setPhone(data);//按phone查询
        }else{
            //数据格式有误
            return null;
        }

        //执行查询

        //执行查询-------根据设置的条件，查询一个对象
        Employee employee = employeeMapper.selectOne(employeeUser);

        if (employee==null){
            //用户名或电话号码不存在，可用
            return true;
        }else{
            return false;
        }

        }


    /**
     * 用户注册的方法
     * @param employee
     * @return
     * 此时，还需要设置，用户编号，密码需要通过md5,盐来加密，还需要动态生成盐
     *
     */
    @Override
    public Boolean registerUser(Employee employee) {
        //得到盐----------我们可以采用一个工具类生成盐
        String salt = CodecUtils.generateSalt();


        //对用户输入的密码进行MD5加密
        employee.setPassword(CodecUtils.md5Hex(employee.getPassword(),salt));


        //将盐设置到employee中
        employee.setSalt(salt);

        //受影响行数为 1 ，代表注册成功，方法返回true,反之为false
        return  employeeMapper.insertSelective(employee)==1;

    }


    /**
     * 根据用户名与密码，查询数据
     * @param username
     * @param password
     * @return
     */
    @Override
    public Employee queryUser(String username, String password) {
       //创建一个employee对象，封装查询条件
        Employee employee=new Employee();
        //根据查询条件查询对象
        employee.setUsername(username);

        Employee user = employeeMapper.selectOne(employee);

         if (user==null){
             return null;//用户名不存在
         }

         //从数据库，获得当前用户生成的盐
        String salt=user.getSalt();


        //比较用户输入的密码与数据库查询出来的密码是否一致
        //比较密码是否一致(对用户输入的密码，加盐，然后md5加密，得到一个结果，再与数据库的正确密码比较)
        if (CodecUtils.md5Hex(password,salt).equals(user.getPassword())){
            return null;//密码错误
        }
        return  user;//返回正确结果

    }


}
