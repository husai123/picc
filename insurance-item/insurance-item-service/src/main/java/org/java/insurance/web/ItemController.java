package org.java.insurance.web;


import com.alibaba.druid.sql.PagerUtils;
import org.java.insurance.entity.Item;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/category")
public class ItemController {
    @Autowired
    private ItemService itemService;


    /**
     * 销案查询
     * @param page
     * @param limit
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/category/list
     */

    @GetMapping("/list")
    public ResponseEntity<PageResult<Item>> loadItem(Integer page,Integer limit){
        PageResult<Item>  pageResult=itemService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }


}
