package org.java.insurance.service;

import org.java.insurance.entity.Vehicle;
import org.java.insurance.ov.PageResult;

public interface VehicleService {
    PageResult<Vehicle> findAll(Integer page, Integer limit);
}
