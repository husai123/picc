package org.java.insurance.service;

import org.java.insurance.entity.Damage;
import org.java.insurance.ov.PageResult;

public interface DamageService {
    PageResult<Damage> findAll(Integer page, Integer limit);
}
