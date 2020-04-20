package org.java.insurance.service;

import org.java.insurance.entity.employee;
import org.java.insurance.entity.permission;
import org.java.insurance.entity.policy;

import java.util.List;

public interface backUserService {
    public employee querybackstageById(String id);
    public permission querypermissionById(String id);
    public List<policy> selectone();
}
