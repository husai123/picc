package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Robbery;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.VehicleMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
     private VehicleMapper vehicleMapper;

    /**
     * 查询车辆定损
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageResult<Vehicle> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);

        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(vehicleMapper.selectAll());

        //获得分页查询的结果
        List list=info.getList();

        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.VEHICLE_LIST_NOT_FOUND);
        }
        //如果查询结果不为空，则封装成pageResult
        PageResult<Vehicle> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数
        return pageResult;
    }


    /**
     * 根据id删除
     * @param vehicle_damage_id
     */
    @Override
    public void delByid(Integer vehicle_damage_id) {
        int count = vehicleMapper.deleteByPrimaryKey(vehicle_damage_id);//删除数据返回受影响的行数
        if (count==0){
            //删除失败
            throw new  InsuranceException(InsuranceEnum.VEHICLE__REMOVE_ERROR);
        }
    }


    /**
     * 车辆定损添加
     *
     * @param vehicle
     */
    @Override
    public void saveItem(Vehicle vehicle) {
  //      itemMapper.insertSelective(vehicle) //给对象中的非空属性赋值
        int count = vehicleMapper.insert(vehicle);//给对象中所有属性赋值
        if (count==0){
            throw new InsuranceException(InsuranceEnum.VEHICLE_ADD_ERROR);
        }
    }


    /**
     * 车辆定损修改
     * @param vehicle
     */
    @Override
    public void updateItem(Vehicle vehicle) {
        int count = vehicleMapper.updateByPrimaryKey(vehicle);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.VEHICLE_UPDATE_ERROR);
        }

    }
}
