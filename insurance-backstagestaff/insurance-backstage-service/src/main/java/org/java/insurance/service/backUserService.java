package org.java.insurance.service;

import org.java.insurance.entity.employee;
import org.java.insurance.entity.permission;

public interface backUserService {
    public employee querybackstageById(String id);
    public permission querypermissionById(String id);
    public void updatePermissionPwd(String id,String uname,String phone);
}
