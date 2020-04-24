package org.java.insurance.web;

import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.entity.Robbery;
import org.java.insurance.entity.Robbery_verify;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.GoodsService;
import org.java.insurance.service.Goods_verifyService;
import org.java.insurance.service.RobberyService;
import org.java.insurance.service.Robbery_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("robberyVerify")
@RestController
public class Robbery_verifyController {
    @Autowired
    private Robbery_verifyService robbery_verifyService;
    @Autowired
    private RobberyService robberyService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Robbery>> loadItem(Integer page, Integer limit){
        PageResult<Robbery>  pageResult=robbery_verifyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/getVerify")
    public ResponseEntity<List<Robbery_verify>> loadItem(@RequestParam("Robbery_damage_id") String pid){
        System.out.println("666");
        List<Robbery_verify> list= robbery_verifyService.findRobbery_verifyByID(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Robbery_verify damage){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        damage.setVerify_time(new Date());
        robbery_verifyService.updateItem(damage);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/refuse")
    public ResponseEntity<Void> refuseItem(@RequestParam("Robbery_damage_id") String pid){
        robbery_verifyService.refuseItem(pid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
