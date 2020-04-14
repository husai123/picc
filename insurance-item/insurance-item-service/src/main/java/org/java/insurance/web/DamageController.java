package org.java.insurance.web;


import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Goods;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/human")
public class DamageController {


    @Autowired
    private DamageService damageService;



    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */


    /**
     *查询人损定损
     * @param page
     * @param limit
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/human/list
     */
    @GetMapping("/list")
    public ResponseEntity<PageResult<Damage>> loadItem(Integer page, Integer limit){
        PageResult<Damage>  pageResult=damageService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }


    /**
     * 根据id删除
     * @param human_injury_damage_id
     * @return
     * 网关访问地址 http://api.insurance.com/api/item/human/del？id=xxx
     */
    @DeleteMapping("/del")
    public ResponseEntity<Void> del(Integer human_injury_damage_id){
        damageService.delByid(human_injury_damage_id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 人损定损新增
     * @param damage
     * @return
     * 通过网关访问该地址是:http://api.insurance.com/api/item/human/save?json对象
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveItem(Damage damage){
        damageService.saveItem(damage);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 人损定损修改
     * http://api.insurance.com/api/item/human/update
     * @param damage
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Damage damage){
        damageService.updateItem(damage);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
