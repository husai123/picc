package org.java.order.web;


import org.java.insurance.ov.PageResult;
import org.java.insurance.util.JsonUtils;
import org.java.order.pojo.Type_Of_Insurance_Item;
import org.java.order.service.OrderService;
import org.java.order.util.InquiryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    /**
     * 根据  客户编号  查询所有该客户的询价订单
     * 订单的状态为：0：待提交，1：待报价 ，2：待完善，3：待支付
     */
    @GetMapping("/inquiryList/{cust_id}")
    public ResponseEntity<PageResult<InquiryOrder>> queryInquiry(
                                                @PathVariable("cust_id")String cust_id,
                                                @RequestParam("page")Integer page,
                                                @RequestParam("limit")Integer limit
                                                ){
        System.out.println("查询询价订单集合************");
        PageResult<InquiryOrder> pageResult = orderService.queryInquiry(cust_id,page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }


    /**
     * 提交订单询价
     * 工作流向前推进一步 进入报价员报价
     */
    @PostMapping("/submit_inquiry/{order_id}")
    public ResponseEntity<Void> submit_inquiry(@PathVariable("order_id")String order_id){
        orderService.submit_inquiry(order_id);
        return ResponseEntity.ok(null);
    }

}
