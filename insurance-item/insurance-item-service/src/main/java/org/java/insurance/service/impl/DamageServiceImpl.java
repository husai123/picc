package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Goods;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.DamageMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DamageServiceImpl implements DamageService{

    @Autowired
    private DamageMapper damageMapper;


    /**
     * 查询人伤定损
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageResult<Damage> findAll(Integer page, Integer limit) {

        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);

        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(damageMapper.selectAll());

        //获得分页查询的结果
        List list=info.getList();

        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }
        //如果查询结果不为空，则封装成pageResult
        PageResult<Damage> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数


        return pageResult;

    }


    /**
     * 根据id删除人伤定损
     * @param human_injury_damage_id
     */
    @Override
    public void delByid(Integer human_injury_damage_id) {
        int count = damageMapper.deleteByPrimaryKey(human_injury_damage_id);

        if (count==0){
            //删除失败
            throw new InsuranceException(InsuranceEnum.DAMAGE__REMOVE_ERROR);
        }
    }


    /**
     * 新增人伤定损
     * @param damage
     */
    @Override
    public void saveItem(Damage damage) {
        //        itemMapper.insertSelective(item) //给对象中的非空属性赋值
        int count = damageMapper.insert(damage);//给对象中所有属性赋值
        if (count==0){
            throw new InsuranceException(InsuranceEnum.DAMAGE_ADD_ERROR);
        }
    }


    /**
     * 修改人伤定损
     * @param damage
     */
    @Override
    public void updateItem(Damage damage) {
        int count = damageMapper.updateByPrimaryKey(damage);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.DAMAGE_UPDATE_ERROR);
        }
    }

}
