package org.java.insurance.web;


import com.alibaba.druid.sql.PagerUtils;
import org.java.insurance.entity.Item;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class ItemController {
    @Autowired
    private ItemService itemService;


    /**
     * get  查询
     * post 新增
     * put  修改
     * delete 删除
     */




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


    /**
     * 销案删除
     * @param case_closed_id
     * @return
     * 通过网关访问该地址是：http://api.insurance.com/api/item/category/del？id=xxx
     */
    @DeleteMapping("/del")
    public ResponseEntity<Void>  del(Integer case_closed_id){
        itemService.delByid(case_closed_id);

        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 销案新增
     * @param item
     * @return
     * 通过网关访问该地址是:http://api.insurance.com/api/item/category/save?json对象
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveItem(Item item){
        itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 销案修改
     * http://api.insurance.com/api/item/category/update
     * @param item
     * @return
     */
     @PutMapping("/update")
    public ResponseEntity<Void> updateItem(Item item){
          itemService.updateItem(item);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }



}
