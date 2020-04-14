package org.java.insurance.web;

import org.java.insurance.entity.Item;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("vehicle")
@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;



    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */


    /**
     * 车辆定损查询
     * @param page
     * @param limit
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/vehicle/list
     */

    @GetMapping("/list")
    public ResponseEntity<PageResult<Vehicle>> loadItem(Integer page, Integer limit){
        PageResult<Vehicle>  pageResult=vehicleService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    /**
     * 车辆定损删除
     * @param vehicle_damage_id
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/vehicle/del？id=xxx
     */
    @DeleteMapping("/del")
    public ResponseEntity<Void>  del(Integer vehicle_damage_id){
        vehicleService.delByid(vehicle_damage_id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 车辆定损新增
     * @param vehicle
     * @return
     * 通过网关访问该地址是:http://api.insurance.com/api/item/vehicle/save?json对象
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveItem(Vehicle vehicle){
        vehicleService.saveItem(vehicle);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    /**
     * 车辆定损修改
     * http://api.insurance.com/api/item/vehicle/update
     * @param vehicle
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Vehicle vehicle){
        vehicleService.updateItem(vehicle);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }








}
