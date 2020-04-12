package org.java.customer.service.impl;

import org.java.customer.dao.CustomerMapper;
import org.java.customer.pojo.Customer;
import org.java.customer.service.CustomerService;
import org.java.customer.util.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 检查数据是否可用，true:可用，false:不可用
     * @param data
     * @param type  它的值，只允许是1，2， 1：邮箱  2：手机号
     * @return
     */
    @Override
    public Boolean checkData(String data, Integer type) {

        //创建Customer对象，封装查询数据
        Customer recode=new Customer();

        if(type==1){
            recode.setCust_email(data);//按email查询
        }else if(type==2){
            recode.setCust_phone(data);//按phone查询
        }else{
            //数据格式有误
            return null;
        }

        //执行查询-------根据设置的条件，查询一个对象
        Customer user = customerMapper.selectOne(recode);

        if(user==null){
            //邮箱或电话号码不存在，可用
            return true;
        }else{
            return false;
        }
    }

    /**
     * 用户注册的方法
     * @param customer
     * @return
     * 参数customer中，包含：CUST_TRUENAME 姓名,CUST_SEX 性别,CUST_IDENTITY 身份证号码，CUST_PHONE 电话号码
     *                     CUST_EMAIL 电子邮箱，CUST_BANK_CARD 客户开户银行卡号，CUST_HEAD_IMG 用户头像，
     *                     CUST_ADDRESS 用户详细地址，CUST_BIRTHDAY 用户出生日期，CUST_PASSWORD 登录密码
     *
     * 此时，还需要设置，用户编号，密码需要通过md5,盐来加密，还需要动态生成盐
     */
    @Override
    public Boolean registerUser(Customer customer) {
        System.out.println("111111111");
        //设置用户编号
        customer.setCust_id(UUID.randomUUID().toString());

        //得到盐----------我们可以采用一个工具类生成盐
        String salt = CodecUtils.generateSalt();

        //对用户输入的密码进行MD5加密
        customer.setCust_password(CodecUtils.md5Hex(customer.getCust_password(),salt));

        //将盐设置到user中
        customer.setSalt(salt);

        //受影响行数为 1 ，代表注册成功，方法返回true,反之为false
        return  customerMapper.insertSelective(customer)==1;
    }

    @Override
    public Customer queryCustomerById(String id) {
        return customerMapper.queryCustomerById(id);
    }


    /**
     * 根据用户电话号或邮箱与密码，查询数据
     * @param date
     * @param password
     * @return
     */
    @Override
    public Customer queryUser(String date, String password) {
        //创建一个User对象，封装查询条件
//        Customer recode = new Customer();
        //根据查询条件查询对象,有@符号就查邮箱，没有就查电话号码
//        if(date.indexOf("@")!=-1){
//            recode.setCust_email(date);
//        }else{
//            recode.setCust_phone(date);
//        }

//        System.out.println(recode);


        Customer customer = customerMapper.findByOne(date);


        if(customer ==null){
            return null;//电话号码或邮箱不存在
        }

        //从数据库，获得当前用户生成的盐
        String salt = customer.getSalt();


        //比较用户输入的密码与数据库查询出来的密码是否一致
        //比较密码是否一致(对用户输入的密码，加盐，然后md5加密，得到一个结果，再与数据库的正确密码比较)
        if(!CodecUtils.md5Hex(password,salt).equals(customer.getCust_password())){
            return null;//密码错误
        }

        return customer;//返回正确的数据
    }

    @Override
    public Customer queryUserbyId(String name) {
        Customer customer = customerMapper.UserbyId(name);
        return customer;
    }

    @Override
    public void updatePwd(String uname, String pwd) {
        Customer customer = customerMapper.UserbyId(uname);
        //得到盐----------我们可以采用一个工具类生成盐
        String salt = CodecUtils.generateSalt();
        //对用户输入的密码进行MD5加密
        customer.setCust_password(CodecUtils.md5Hex(pwd,salt));
        customer.setSalt(salt);
        customerMapper.updateByPrimaryKey(customer);
        //将盐设置到user中

    }

    @Override
    public void updateInfo(String uname, String phone, String email) {
        Customer customer = customerMapper.UserbyId(uname);
        customer.setCust_email(email);
        customer.setCust_phone(phone);
        customer.setCust_truename(uname);
        customerMapper.updateByPrimaryKey(customer);
    }

//    @Override
//    public void updateSalt(String uname, String salt) {
//        salt = CodecUtils.generateSalt();
//        customerMapper.updateSalt(uname,salt);
//    }


}
