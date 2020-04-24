package org.java.insurance.service;

import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.entity.Robbery;
import org.java.insurance.entity.Robbery_verify;
import org.java.insurance.ov.PageResult;

import java.util.List;


public interface Robbery_verifyService {
    PageResult<Robbery> findAll(Integer page, Integer limit);

    /*List<Vehicle> findVehicleByID(Integer Id);*/

    List<Robbery_verify> findRobbery_verifyByID(String Id);

    void updateItem(Robbery_verify robbery_verify);

    void refuseItem(String pid);
}
