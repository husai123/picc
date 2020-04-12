package org.java.insurance.service;

import org.java.insurance.entity.Robbery;
import org.java.insurance.ov.PageResult;

public interface RobberyService {
    PageResult<Robbery> findAll(Integer page, Integer limit);
}
