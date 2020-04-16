package org.java.insurance.service.impl;

import org.java.insurance.dao.backUserMapper;
import org.java.insurance.dao.employeeMapper;
import org.java.insurance.dao.permissionMapper;
import org.java.insurance.dao.rolePermissionMapper;
import org.java.insurance.entity.backUser;
import org.java.insurance.entity.permission;
import org.java.insurance.entity.role_employee_relationship;
import org.java.insurance.entity.role_permission_relationship;
import org.java.insurance.service.backUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class backUserServiceImpl implements backUserService {
    @Autowired
    private backUserMapper backUserMapper;
    @Autowired
    private employeeMapper employeeMapper;
    @Autowired
    private permissionMapper permissionMapper;
    @Autowired
    private rolePermissionMapper rolePermissionMapper;

    //查询员工信息
    @Override
    public backUser querybackstageById(Long id) {
        return backUserMapper.querybackstageById(id);
    }
    //查询员工职位
    @Override
    public permission querypermissionById(Long id) {
        role_employee_relationship emp = backUserMapper.queryemployeeById(id);
        role_permission_relationship per = backUserMapper.queryrolepermissionById(emp.getRole_id());
        permission permission = backUserMapper.querypermissionById(per.getPermission_id());
        return permission;
    }
    //修改信息
    @Override
    public void updatePermissionPwd(Long id,String uname,String phone) {
        backUser backUser = backUserMapper.querybackstageById(id);
        backUser.setPhone(phone);
        backUser.setUsername(uname);
        backUserMapper.updateByPrimaryKey(backUser);
    }
}
