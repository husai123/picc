package org.java.insurance.service;

import org.java.insurance.entity.Robbery;
import org.java.insurance.ov.PageResult;

public interface RobberyService {
    PageResult<Robbery> findAll(Integer page, Integer limit);

    void delByid(Integer robbery_damage_id);

    void saveItem(Robbery robbery);

    void updateItem(Robbery robbery);
}
