package org.java.order.util;

import org.java.order.pojo.Car;
import org.java.order.pojo.Customer_Order;
import org.java.order.pojo.Insured_Info;

import java.io.Serializable;
import java.util.List;

public class InquiryOrder {

    private Customer_Order customer_order;//询价订单信息

    private Car car;//车辆信息

    private Insured_Info insured_info;//被保人信息

    private List<InsuranceItem> insuranceItem;//险种项











    public List<InsuranceItem> getInsuranceItem() {
        return insuranceItem;
    }

    public void setInsuranceItem(List<InsuranceItem> insuranceItem) {
        this.insuranceItem = insuranceItem;
    }

    public Insured_Info getInsured_info() {
        return insured_info;
    }

    public void setInsured_info(Insured_Info insured_info) {
        this.insured_info = insured_info;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer_Order getCustomer_order() {
        return customer_order;
    }

    public void setCustomer_order(Customer_Order customer_order) {
        this.customer_order = customer_order;
    }
}
