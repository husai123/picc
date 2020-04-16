package org.java.insurance.service;

import org.java.insurance.entity.backUser;
import org.java.insurance.entity.permission;
import org.java.insurance.entity.role_employee_relationship;

public interface backUserService {
    public backUser querybackstageById(Long id);
    public permission querypermissionById(Long id);
}
