package org.java.insurance.web;


import org.java.insurance.entity.Goods;
import org.java.insurance.entity.Item;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/material")
public class goodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */


    /**
     *查询物损定损
     * @param page
     * @param limit
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/material/list
     */
    @GetMapping("/list")
    public ResponseEntity<PageResult<Goods>> loadItem(Integer page, Integer limit){
        PageResult<Goods>  pageResult=goodsService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }


    /**
     * 根据id删除
     * @param damage_of_goods_id
     * @return
     * 网关访问地址 http://api.insurance.com/api/item/material/del？id=xxx
     */
    @DeleteMapping("del")
    public ResponseEntity<Void> del(Integer damage_of_goods_id){
         goodsService.delById(damage_of_goods_id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 物损定损新增
     * @param goods
     * @return
     * 通过网关访问该地址是:http://api.insurance.com/api/item/material/save?json对象
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveItem(Goods goods){
        goodsService.saveItem(goods);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 物损定损修改
     * http://api.insurance.com/api/item/material/update
     * @param goods
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Goods goods){
        goodsService.updateItem(goods);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }






}
