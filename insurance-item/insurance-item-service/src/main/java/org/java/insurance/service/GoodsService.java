package org.java.insurance.service;

import org.java.insurance.entity.Goods;
import org.java.insurance.ov.PageResult;

public interface GoodsService {
    PageResult<Goods> findAll(Integer page, Integer limit);

    void delById(Integer damage_of_goods_id);

    void saveItem(Goods goods);

    void updateItem(Goods goods);
}
