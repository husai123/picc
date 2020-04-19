package org.java.insurance.service;

import org.java.insurance.entity.Data_dictionary;

import java.util.List;

public interface Data_dictionaryService {
    List<Data_dictionary> findById(Integer ID);
}
