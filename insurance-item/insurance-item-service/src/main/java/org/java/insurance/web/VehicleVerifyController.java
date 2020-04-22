package org.java.insurance.web;

import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.entity.Vehicle_damage_verify;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.VehicleService;
import org.java.insurance.service.VehicleVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("vehicleVerify")
@RestController
public class VehicleVerifyController {
    @Autowired
    private VehicleVerifyService vehicleVerifyService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Vehicle>> loadItem(Integer page, Integer limit){
        PageResult<Vehicle>  pageResult=vehicleVerifyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/getVerify")
    public ResponseEntity<List<Vehicle_damage_verify>> loadItem(@RequestParam("vehicle_damage_id") String pid){
        System.out.println("666");
        List<Vehicle_damage_verify> list= vehicleVerifyService.findVehicle_damage_verifyByID(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Vehicle_damage_verify damage){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        damage.setVerify_time(new Date());
        vehicleVerifyService.updateItem(damage);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
