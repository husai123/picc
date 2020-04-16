package org.java.insurance.dao;

import org.java.insurance.entity.backUser;
import org.java.insurance.entity.permission;
import org.java.insurance.entity.role_employee_relationship;
import org.java.insurance.entity.role_permission_relationship;
import tk.mybatis.mapper.common.Mapper;

public interface backUserMapper extends Mapper<backUser> {
    public backUser querybackstageById(Long id);
    public role_employee_relationship queryemployeeById(Long id);
    public permission querypermissionById(Integer id);
    public role_permission_relationship queryrolepermissionById(Integer id);
}
