package org.java.user.mapper;


import org.java.user.pojo.Employee;
import tk.mybatis.mapper.common.Mapper;


/**
 * mapper 接口
 */
public interface EmployeeMapper extends Mapper<Employee> {
     public Employee querybackstageById(String id);
     public Employee UserbyId(String name);
}
