package org.java.insurance.web;


import org.java.insurance.entity.Damage;
import org.java.insurance.entity.Goods;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
