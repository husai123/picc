package org.java.insurance.web;

import org.java.insurance.entity.Item;
import org.java.insurance.entity.Robbery;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.RobberyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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






}
