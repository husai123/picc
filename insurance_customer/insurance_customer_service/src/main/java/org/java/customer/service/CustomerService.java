package org.java.customer.service;

import org.java.customer.pojo.Customer;

public interface CustomerService {

    /**
     * 检查数据是否可用，true:可用，false:不可用
     * @param data
     * @param type  它的值，只允许是1，2， 1：邮箱  2：手机号
     * @return
     */
    public Boolean checkData(String data, Integer type);

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
    public Boolean registerUser(Customer customer);

    /**
     * 根据用户电话号或邮箱与密码，查询数据
     * @param date
     * @param password
     * @return
     */
    public Customer queryUser(String date, String password);
}
