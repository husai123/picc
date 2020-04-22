package org.java.insurance.web;

import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Human_verify;
import org.java.insurance.entity.Vehicle;
import org.java.insurance.entity.Vehicle_damage_verify;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DamageService;
import org.java.insurance.service.Human_verifyService;
import org.java.insurance.service.VehicleService;
import org.java.insurance.service.VehicleVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("humanVerify")
@RestController
public class Human_verifyController {
    @Autowired
    private Human_verifyService human_verifyService;
    @Autowired
    private DamageService damageService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Damage>> loadItem(Integer page, Integer limit){
        PageResult<Damage>  pageResult=human_verifyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/getVerify")
    public ResponseEntity<List<Human_verify>> loadItem(@RequestParam("Human_injury_damage_id") String pid){
        System.out.println("666");
        List<Human_verify> list= human_verifyService.findHuman_verifyByID(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Human_verify damage){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        damage.setVerify_time(new Date());
        human_verifyService.updateItem(damage);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
