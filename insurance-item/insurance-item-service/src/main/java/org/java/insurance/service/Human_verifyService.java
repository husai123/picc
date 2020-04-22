package org.java.insurance.service;

import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Human_verify;
import org.java.insurance.ov.PageResult;

import java.util.List;


public interface Human_verifyService {
    PageResult<Damage> findAll(Integer page, Integer limit);

    /*List<Vehicle> findVehicleByID(Integer Id);*/

    List<Human_verify> findHuman_verifyByID(String Id);

    void updateItem(Human_verify human_verify);
}
