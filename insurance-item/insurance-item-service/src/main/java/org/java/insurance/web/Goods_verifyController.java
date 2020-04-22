package org.java.insurance.web;

import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Goods_verify;
import org.java.insurance.entity.Human_verify;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DamageService;
import org.java.insurance.service.GoodsService;
import org.java.insurance.service.Goods_verifyService;
import org.java.insurance.service.Human_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("goodsVerify")
@RestController
public class Goods_verifyController {
    @Autowired
    private Goods_verifyService goods_verifyService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Goods>> loadItem(Integer page, Integer limit){
        PageResult<Goods>  pageResult=goods_verifyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/getVerify")
    public ResponseEntity<List<Goods_verify>> loadItem(@RequestParam("Damage_of_goods_id") String pid){
        System.out.println("666");
        List<Goods_verify> list= goods_verifyService.findGoods_verifyByID(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Goods_verify damage){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        damage.setVerify_time(new Date());
        goods_verifyService.updateItem(damage);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
