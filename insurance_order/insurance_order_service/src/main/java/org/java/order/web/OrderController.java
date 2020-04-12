package org.java.order.web;


import org.java.insurance.util.JsonUtils;
import org.java.order.pojo.Type_Of_Insurance_Item;
import org.java.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 订单控制器类
 */
@RestController
@RequestMapping("/insuanceOrder")
public class OrderController {

    @Autowired
    private OrderService orderService;



    /**
     * 获取创建订单需要的信息
     */
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestParam Map map){
        String orderId = orderService.createOrder(map);

        return ResponseEntity.ok(orderId);
    }


}
