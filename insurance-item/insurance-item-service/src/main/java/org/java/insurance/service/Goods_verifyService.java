package org.java.insurance.service;

import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.ov.PageResult;

import java.util.List;


public interface Goods_verifyService {
    PageResult<Goods> findAll(Integer page, Integer limit);

    /*List<Vehicle> findVehicleByID(Integer Id);*/

    List<Goods_verify> findGoods_verifyByID(String Id);

    void updateItem(Goods_verify goods_verify);
}
