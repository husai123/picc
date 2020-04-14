package org.java.insurance.service;

import org.java.insurance.entity.Vehicle;
import org.java.insurance.ov.PageResult;

public interface VehicleService {
    PageResult<Vehicle> findAll(Integer page, Integer limit);

    void delByid(Integer vehicle_damage_id);

    void saveItem(Vehicle vehicle);

    void updateItem(Vehicle vehicle);
}
