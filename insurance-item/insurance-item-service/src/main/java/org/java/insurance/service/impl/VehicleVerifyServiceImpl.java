package org.java.insurance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.java.insurance.entity.Data_dictionary;
import org.java.insurance.entity.Document;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.entity.Vehicle_damage_verify;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.mapper.VehicleMapper;
import org.java.insurance.mapper.Vehicle_damage_verifyMapper;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.VehicleVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class VehicleVerifyServiceImpl implements VehicleVerifyService {

    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private Vehicle_damage_verifyMapper vehicle_damage_verifyMapper;

    @Override
    public PageResult<Vehicle> findAll(Integer page, Integer limit) {
        //使用pageHelper分页查询
        PageHelper.startPage(page,limit);
        //创建一个Example对象，封装查询条件
        Example example = new Example(Vehicle.class);
        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();

            //指定查询条件
        criteria.andGreaterThan("opinion_material_fee",200000);
        criteria.andEqualTo("instance_id",1);
        //分页查询  info对象，包含了分页的全部数据
        PageInfo info=new PageInfo(vehicleMapper.selectByExample(example));

        //获得分页查询的结果
        List list=info.getList();

        /*if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.VEHICLE_LIST_NOT_FOUND);
        }*/
        //如果查询结果不为空，则封装成pageResult
        PageResult<Vehicle> pageResult=new PageResult<>();
        pageResult.setData(list);//封装查询结果
        pageResult.setCode(0);//数据正常
        pageResult.setCount(info.getTotal());//设置查询到的数据总数
        return pageResult;
    }

    /*@Override
    public List<Vehicle> findVehicleByID(Integer Id) {
        Vehicle vehicle = new Vehicle();
        Vehicle.setVehicle_damage_id(Id);//设置要查询的id

        //查询
        List<Vehicle> list = vehicleMapper.select(vehicle);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }
        return list;
    }*/

    @Override
    public List<Vehicle_damage_verify> findVehicle_damage_verifyByID(String Id) {
        Vehicle_damage_verify vehicle_damage_verify = new Vehicle_damage_verify();
        vehicle_damage_verify.setVehilce_damage_id(Id);//设置要查询的id

        //查询
        List<Vehicle_damage_verify> list = vehicle_damage_verifyMapper.select(vehicle_damage_verify);
        if (CollectionUtils.isEmpty(list)){
            throw new InsuranceException(InsuranceEnum.Document_LIST_NOT_FOUND);
        }

        return list;
    }

    @Override
    public void updateItem(Vehicle_damage_verify vehicle_damage_verify) {
        vehicle_damage_verify.setIs_adopt("1");
        Integer id = Integer.valueOf(vehicle_damage_verify.getVehilce_damage_id());
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_damage_id(id);//设置要查询的id
        //查询
        List<Vehicle> list = vehicleMapper.select(vehicle);
        Vehicle vehicle1 = list.get(0);
        vehicle1.setInstance_id("2");
        vehicleMapper.updateByPrimaryKey(vehicle1);

        int count = vehicle_damage_verifyMapper.updateByPrimaryKey(vehicle_damage_verify);
        if (count==0){
            throw new InsuranceException(InsuranceEnum.GOODS_UPDATE_ERROR);
        }
    }

    @Override
    public void refuseItem(String pid) {
        Integer id = Integer.valueOf(pid);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_damage_id(id);//设置要查询的id
        //查询
        List<Vehicle> list = vehicleMapper.select(vehicle);
        Vehicle vehicle1 = list.get(0);
        vehicle1.setInstance_id("0");
        vehicleMapper.updateByPrimaryKey(vehicle1);
    }
}
