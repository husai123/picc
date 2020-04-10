package org.java.insurance.service;

import org.java.insurance.entity.Item;
import org.java.insurance.ov.PageResult;

import java.util.List;

public interface ItemService {
    public PageResult<Item> findAll(Integer page, Integer limit);
}