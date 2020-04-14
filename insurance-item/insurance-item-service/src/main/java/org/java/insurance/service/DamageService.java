package org.java.insurance.service;

import org.java.insurance.entity.Damage;
import org.java.insurance.ov.PageResult;

public interface DamageService {
    PageResult<Damage> findAll(Integer page, Integer limit);

    void delByid(Integer human_injury_damage_id);

    void saveItem(Damage damage);

    void updateItem(Damage damage);
}
