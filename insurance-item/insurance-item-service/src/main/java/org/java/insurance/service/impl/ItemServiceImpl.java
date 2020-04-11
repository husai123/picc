package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Item;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.ItemMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{


    @Autowired
    private ItemMapper itemMapper;


    /**
     * 查询销案表
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageResult<Item> findAll(Integer page, Integer limit) {

             //使用pageHelper分页查询
        PageHelper.startPage(page,limit);

        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(itemMapper.selectAll());

        //获得分页查询的结果
        List list=info.getList();

        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.BRAND_LIST_NOT_FOUND);
        }
        //如果查询结果不为空，则封装成pageResult
        PageResult<Item> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数
        return pageResult;
    }


    /**
     * 根据销案id删除销案
     * @param case_closed_id
     */
    @Override
    public void delByid(Integer case_closed_id) {
        int count = itemMapper.deleteByPrimaryKey(case_closed_id);//删除数据返回受影响的行数
          if (count==0){
              //删除失败
              throw new  ShoppingException(ShoppingEnum.BRAND_REMOVE_ERROR);
          }

    }


    /**
     * 新增销案
     * @param item
     */
    @Override
    public void saveItem(Item item) {
//        itemMapper.insertSelective(item) //给对象中的非空属性赋值
        int count = itemMapper.insert(item);//给对象中所有属性赋值
        if (count==0){
            throw new ShoppingException(ShoppingEnum.BRAND_ADD_ERROR);
        }

    }


}
