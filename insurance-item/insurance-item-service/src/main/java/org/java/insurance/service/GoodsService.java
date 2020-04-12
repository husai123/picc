package org.java.insurance.service;

import org.java.insurance.entity.Goods;
import org.java.insurance.ov.PageResult;

public interface GoodsService {
    PageResult<Goods> findAll(Integer page, Integer limit);
}
