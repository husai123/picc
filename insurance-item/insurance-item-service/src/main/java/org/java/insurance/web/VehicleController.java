package org.java.insurance.web;

import org.java.insurance.entity.Item;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 销案查询
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




}
