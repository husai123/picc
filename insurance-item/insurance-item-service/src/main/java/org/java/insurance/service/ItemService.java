package org.java.insurance.service;

import org.java.insurance.entity.Item;
import org.java.insurance.ov.PageResult;

import java.util.List;

public interface ItemService {
    public PageResult<Item> findAll(Integer page, Integer limit);

    void delByid(Integer case_closed_id);

    void saveItem(Item item);

    void updateItem(Item item);
}
