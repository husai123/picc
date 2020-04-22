package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.entity.Human_verify;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.DamageMapper;
import org.java.insurance.mapper.GoodsMapper;
import org.java.insurance.mapper.Goods_verifyMapper;
import org.java.insurance.mapper.Human_verifyMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Goods_verifyService;
import org.java.insurance.service.Human_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class Goods_verifyServiceImpl implements Goods_verifyService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private Goods_verifyMapper goods_verifyMapper;



    @Override
    public PageResult<Goods> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Goods.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("instance_id",1);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(goodsMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Damage_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Goods> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数

        return pageResult;
    }

    @Override
    public List<Goods_verify> findGoods_verifyByID(String Id) {
        Goods_verify goods_verify = new Goods_verify();
        goods_verify.setDamage_of_goods_id(Id);//设置要查询的id
        //查询
        List<Goods_verify> list = goods_verifyMapper.select(goods_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    @Override
    public void updateItem(Goods_verify goods_verify) {
        goods_verify.setIs_adopt("1");
        Integer id = Integer.valueOf(goods_verify.getDamage_of_goods_id());
        Goods goods = new Goods();
        goods.setDamage_of_goods_id(id);//设置要查询的id
        //查询
        List<Goods> list = goodsMapper.select(goods);
        Goods goods1 = list.get(0);
        goods1.setInstance_id("2");
        goodsMapper.updateByPrimaryKey(goods1);

        int count = goods_verifyMapper.updateByPrimaryKey(goods_verify);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }
}
