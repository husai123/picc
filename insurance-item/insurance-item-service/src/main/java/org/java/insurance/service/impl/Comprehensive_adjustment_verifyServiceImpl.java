package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Comprehensive_adjustment_verify;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.Comprehensive_adjustment_vertifyMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Comprehensive_adjustment_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class Comprehensive_adjustment_verifyServiceImpl implements Comprehensive_adjustment_verifyService {

    @Autowired
    Comprehensive_adjustment_vertifyMapper comprehensive_adjustment_vertifyMapper;

    @Override
    public PageResult<Comprehensive_adjustment_verify> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Comprehensive_adjustment_verify.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("Instance_id",1);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(comprehensive_adjustment_vertifyMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Comprehensive_adjustment_verify> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public PageResult<Comprehensive_adjustment_verify> findAll2(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Comprehensive_adjustment_verify.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("Instance_id",2);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(comprehensive_adjustment_vertifyMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Comprehensive_adjustment_verify> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public List<Comprehensive_adjustment_verify> findVerifyByID(String Id) {
        Comprehensive_adjustment_verify comprehensive_adjustment_verify = new Comprehensive_adjustment_verify();
        comprehensive_adjustment_verify.setVerify_id(Id);//设置要查询的id
        //查询
        List<Comprehensive_adjustment_verify> list = comprehensive_adjustment_vertifyMapper.select(comprehensive_adjustment_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    public Comprehensive_adjustment_verify findByID(String Id) {
        Comprehensive_adjustment_verify comprehensive_adjustment_verify = new Comprehensive_adjustment_verify();
        comprehensive_adjustment_verify.setVerify_id(Id);//设置要查询的id
        //查询
        List<Comprehensive_adjustment_verify> list = comprehensive_adjustment_vertifyMapper.select(comprehensive_adjustment_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }
        Comprehensive_adjustment_verify comprehensive_adjustment_verify2 = list.get(0);
        return comprehensive_adjustment_verify2;
    }

    @Override
    public void settlementItem(String pid) {
        Comprehensive_adjustment_verify comprehensive_adjustment_verify = findByID(pid);
        comprehensive_adjustment_verify.setInstance_id("2");
        comprehensive_adjustment_vertifyMapper.updateByPrimaryKey(comprehensive_adjustment_verify);
    }

    @Override
    public void ClosingItem(String pid) {
        Comprehensive_adjustment_verify comprehensive_adjustment_verify = findByID(pid);
        comprehensive_adjustment_verify.setInstance_id("3");
        comprehensive_adjustment_vertifyMapper.updateByPrimaryKey(comprehensive_adjustment_verify);
    }
}
