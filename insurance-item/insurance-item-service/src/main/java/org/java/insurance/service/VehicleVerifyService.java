package org.java.insurance.service;

import org.java.insurance.entity.Document;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.entity.Vehicle_damage_verify;
import org.java.insurance.ov.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleVerifyService {
    PageResult<Vehicle> findAll(Integer page, Integer limit);

    /*List<Vehicle> findVehicleByID(Integer Id);*/

    List<Vehicle_damage_verify> findVehicle_damage_verifyByID(String Id);

    void updateItem(Vehicle_damage_verify vehicle_damage_verify);
}
