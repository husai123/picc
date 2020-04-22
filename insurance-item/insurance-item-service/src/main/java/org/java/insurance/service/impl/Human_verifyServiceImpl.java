package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Human_verify;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.entity.Vehicle_damage_verify;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.DamageMapper;
import org.java.insurance.mapper.Human_verifyMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Human_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class Human_verifyServiceImpl implements Human_verifyService {

    @Autowired
    private DamageMapper damageMapper;
    @Autowired
    private Human_verifyMapper human_verifyMapper;



    @Override
    public PageResult<Damage> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Damage.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("instance_id",1);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(damageMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Damage> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public List<Human_verify> findHuman_verifyByID(String Id) {
        Human_verify human_verify = new Human_verify();
        human_verify.setHuman_injury_damage_id(Id);//设置要查询的id
        //查询
        List<Human_verify> list = human_verifyMapper.select(human_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    @Override
    public void updateItem(Human_verify human_verify) {
        human_verify.setIs_adopt("1");
        Integer id = Integer.valueOf(human_verify.getHuman_injury_damage_id());
        Damage damage = new Damage();
        damage.setHuman_injury_damage_id(id);//设置要查询的id
        //查询
        List<Damage> list = damageMapper.select(damage);
        Damage damage1 = list.get(0);
        damage1.setInstance_id("2");
        damageMapper.updateByPrimaryKey(damage1);

        int count = human_verifyMapper.updateByPrimaryKey(human_verify);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }
}
