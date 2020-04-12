package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Item;
import org.java.insurance.enums.ShoppingEnum;
import org.java.insurance.exception.ShoppingException;
import org.java.insurance.mapper.GoodsMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 查询物损定损
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageResult<Goods> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);

        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(goodsMapper.selectAll());

        //获得分页查询的结果
        List list=info.getList();

        if (CollectionUtils.isEmpty(list)){
            throw new ShoppingException(ShoppingEnum.GOODS_LIST_NOT_FOUND);
        }
        //如果查询结果不为空，则封装成pageResult
        PageResult<Goods> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数


        return pageResult;
    }
}
