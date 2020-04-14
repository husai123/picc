package org.java.order.service;

import org.java.insurance.ov.PageResult;
import org.java.order.util.InquiryOrder;

import java.util.Map;

public interface OrderService {

    public String createOrder(Map map);

    public PageResult<InquiryOrder> queryInquiry(String cust_id, Integer page, Integer limit);

    public void submit_inquiry(String order_id);
}
