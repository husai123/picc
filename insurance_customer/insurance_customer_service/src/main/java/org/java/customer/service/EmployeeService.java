package org.java.customer.service;

import org.java.customer.pojo.Employee;

public interface EmployeeService {


    Boolean checkData(String data, Integer type);

    Boolean registerUser(Employee employee);

    Employee queryUser(String username, String password);
}
