package org.java.insurance.dao;

import org.java.insurance.entity.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface backUserMapper extends Mapper<employee> {
    public employee querybackstageById(String id);
    public role_employee_relationship queryemployeeById(String id);
    public permission querypermissionById(Integer id);
    public role_permission_relationship queryrolepermissionById(Integer id);
    public List<policy> selectone();
}
