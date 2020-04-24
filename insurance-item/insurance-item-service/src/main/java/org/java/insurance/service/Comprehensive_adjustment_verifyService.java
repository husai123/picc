package org.java.insurance.service;

import org.java.insurance.entity.Comprehensive_adjustment_verify;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.ov.PageResult;

import java.util.List;

public interface Comprehensive_adjustment_verifyService {

    PageResult<Comprehensive_adjustment_verify> findAll(Integer page, Integer limit);

    PageResult<Comprehensive_adjustment_verify> findAll2(Integer page, Integer limit);

    List<Comprehensive_adjustment_verify> findVerifyByID(String Id);

    void settlementItem(String pid);

    void ClosingItem(String pid);

}
