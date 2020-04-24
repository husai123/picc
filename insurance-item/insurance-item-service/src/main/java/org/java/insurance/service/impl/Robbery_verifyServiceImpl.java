package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.entity.Robbery;
import org.java.insurance.entity.Robbery_verify;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.GoodsMapper;
import org.java.insurance.mapper.Goods_verifyMapper;
import org.java.insurance.mapper.RobberyMapper;
import org.java.insurance.mapper.Robbery_verifyMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Goods_verifyService;
import org.java.insurance.service.Robbery_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class Robbery_verifyServiceImpl implements Robbery_verifyService {

    @Autowired
    private RobberyMapper robberyMapper;
    @Autowired
    private Robbery_verifyMapper robbery_verifyMapper;



    @Override
    public PageResult<Robbery> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Robbery.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("instance_id",1);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(robberyMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Robbery> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public List<Robbery_verify> findRobbery_verifyByID(String Id) {
        Robbery_verify robbery_verify = new Robbery_verify();
        robbery_verify.setRobbery_damage_id(Id);//设置要查询的id
        //查询
        List<Robbery_verify> list = robbery_verifyMapper.select(robbery_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    @Override
    public void updateItem(Robbery_verify robbery_verify) {
        robbery_verify.setIs_adopt("1");
        Integer id = Integer.valueOf(robbery_verify.getRobbery_damage_id());
        Robbery robbery = new Robbery();
        robbery.setRobbery_damage_id(id);//设置要查询的id
        //查询
        List<Robbery> list = robberyMapper.select(robbery);
        Robbery robbery1 = list.get(0);
        robbery1.setInstance_id("2");
        robberyMapper.updateByPrimaryKey(robbery1);

        int count = robbery_verifyMapper.updateByPrimaryKey(robbery_verify);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }

    @Override
    public void refuseItem(String pid) {
        Integer id = Integer.valueOf(pid);
        Robbery robbery = new Robbery();
        robbery.setRobbery_damage_id(id);//设置要查询的id
        //查询
        List<Robbery> list = robberyMapper.select(robbery);
        Robbery robbery1 = list.get(0);
        robbery1.setInstance_id("0");
        robberyMapper.updateByPrimaryKey(robbery1);
    }
}
