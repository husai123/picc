package org.java.insurance.service.impl;


import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.Type_of_insuranceMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Type_of_insuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class Type_of_insuranceImpl implements Type_of_insuranceService {
    @Autowired
    private Type_of_insuranceMapper type_of_insuranceMapper;

    @Override
    public PageResult<Type_of_insurance> findById(String ID) {
        //创建一个Category对象，用于封装查询条件
        Type_of_insurance type_of_insurance = new Type_of_insurance();
        System.out.println(ID);
        type_of_insurance.setInsurance_id(ID);//设置要查询的id

        /*List<Type_of_insurance> list = type_of_insuranceMapper.select(type_of_insurance);*/
        PageInfo info=new PageInfo(type_of_insuranceMapper.select(type_of_insurance));

        //获得分页查询的结果
        List list=info.getList();
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }
        //如果查询结果不为空，则封装成pageResult
        PageResult<Type_of_insurance> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public List<Type_of_insurance> findById2(String ID) {
        Type_of_insurance type_of_insurance = new Type_of_insurance();
        type_of_insurance.setInsurance_id(ID);//设置要查询的id

        //查询
        List<Type_of_insurance> list = type_of_insuranceMapper.select(type_of_insurance);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }
}
