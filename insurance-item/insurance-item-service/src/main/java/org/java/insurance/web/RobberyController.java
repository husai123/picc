package org.java.insurance.web;

import org.java.insurance.entity.Item;
import org.java.insurance.entity.Robbery;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.RobberyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("robbery")
public class RobberyController {


    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */

       @Autowired
       private RobberyService robberyService;


    /**
     * 盗抢查询
     * @param page
     * @param limit
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/robbery/list
     */

    @GetMapping("/list")
    public ResponseEntity<PageResult<Robbery>> loadItem(Integer page, Integer limit){
        PageResult<Robbery>  pageResult=robberyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }


    /**
     * 盗抢删除
     * @param robbery_damage_id
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/robbery/del？id=xxx
     */
    @DeleteMapping("/del")
    public ResponseEntity<Void>  del(Integer robbery_damage_id){
        robberyService.delByid(robbery_damage_id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




    /**
     * 盗抢新增
     * @param robbery
     * @return
     * 通过网关访问该地址是:http://api.insurance.com/api/item/robbery/save?json对象
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveItem(Robbery robbery){
        robberyService.saveItem(robbery);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    /**
     * 盗抢定损修改
     * http://api.insurance.com/api/item/robbery/update
     * @param robbery
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Robbery robbery){
        robberyService.updateItem(robbery);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
