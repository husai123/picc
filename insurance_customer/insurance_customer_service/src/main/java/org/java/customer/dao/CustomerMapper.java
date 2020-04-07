package org.java.customer.dao;

import org.java.customer.pojo.Customer;
import tk.mybatis.mapper.common.Mapper;

public interface CustomerMapper extends Mapper<Customer> {

    public Customer findByOne(String date);

}
