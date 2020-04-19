package org.java.insurance.service;

import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.ov.PageResult;

import java.util.List;

public interface Type_of_insuranceService {
    PageResult<Type_of_insurance> findById(String ID);
    List<Type_of_insurance> findById2(String ID);
}
