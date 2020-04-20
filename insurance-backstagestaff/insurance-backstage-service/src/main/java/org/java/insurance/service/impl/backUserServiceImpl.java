package org.java.insurance.service.impl;

import org.java.insurance.dao.backUserMapper;
import org.java.insurance.entity.*;
import org.java.insurance.service.backUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class backUserServiceImpl implements backUserService {
    @Autowired
    private backUserMapper backUserMapper;

    //查询员工信息
    @Override
    public employee querybackstageById(String id) {
        return backUserMapper.querybackstageById(id);
    }
    //查询员工职位
    @Override
    public permission querypermissionById(String id) {
        role_employee_relationship emp = backUserMapper.queryemployeeById(id);
        role_permission_relationship per = backUserMapper.queryrolepermissionById(emp.getRole_id());
        permission permission = backUserMapper.querypermissionById(per.getPermission_id());
        return permission;
    }

    @Override
    public List<policy> selectone() {
        List<policy> list = backUserMapper.selectone();
        return list;
    }

}
