package org.java.insurance.service.impl;

import org.java.insurance.entity.Data_dictionary;
import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.Data_dictionaryMapper;
import org.java.insurance.service.Data_dictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class Data_dictionaryServiceImpl implements Data_dictionaryService {
    @Autowired
    private Data_dictionaryMapper data_dictionaryMapper;
    @Override
    public List<Data_dictionary> findById(Integer ID) {
        Data_dictionary data_dictionary = new Data_dictionary();
        data_dictionary.setId(ID);//设置要查询的id

        //查询
        List<Data_dictionary> list = data_dictionaryMapper.select(data_dictionary);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    @Override
    public List<Data_dictionary> findAll() {
        //查询
        List<Data_dictionary> list = data_dictionaryMapper.selectAll();
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }
}
