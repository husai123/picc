package org.java.order.service;

import org.java.insurance.ov.PageResult;
import org.java.order.pojo.Type_Of_Insurance;



/**
 * 险种dao
 */
public interface Type_Of_InsuranceService {


    public PageResult<Type_Of_Insurance> findAll();

}
