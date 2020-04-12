package org.java.order.service.impl;

import org.java.customer.pojo.Customer;
import org.java.insurance.util.JsonUtils;
import org.java.order.dao.*;
import org.java.order.feign.CustomerClient;
import org.java.order.pojo.*;
import org.java.order.service.OrderService;
import org.java.order.util.UserInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 客户投保订单
     */
    @Autowired
    private Customer_OrderMapper customer_orderMapper;

    /**
     * 被保人信息
     */
    @Autowired
    private Insured_InfoMapper insured_infoMapper;

    /**
     * 客户信息
     */
    @Autowired
    private CustomerClient customerClient;

    /**
     * 投保人信息
     */
    @Autowired
    private Policy_Holder_InfoMapper policy_holder_infoMapper;

    /**
     * 车辆信息
     */
    @Autowired
    private CarMapper carMapper;

    /**
     * 险种项信息
     */
    @Autowired
    private Type_Of_Insurance_ItemMapper type_of_insurance_itemMapper;

    @Override
    @Transactional
    public String createOrder(Map map) {

        //获取险种项集合
        List<Type_Of_Insurance_Item> list= JsonUtils.parseList(map.get("list").toString(),Type_Of_Insurance_Item.class);
        //删除map中的list
        map.remove("list");

        //获取车辆信息和被保人信息
        UserInsurance userInsurance = JsonUtils.parse(map.get("userInsurance").toString(), UserInsurance.class);
        //删除map中的userInsurance
        map.remove("userInsurance");

        Customer_Order customer_order = JsonUtils.parse(JsonUtils.serialize(map), Customer_Order.class);

        System.out.println(list);
        System.out.println(userInsurance);
        System.out.println(customer_order);

        //设置询价订单号
        String order_id = UUID.randomUUID().toString();

        customer_order.setOrder_id(order_id);//设置订单编号
        customer_order.setStatus("0");//设置订单状态
        customer_order.setToubaochengshi(userInsurance.getToubaochengshi());//设置投保城市
        customer_order.setCar_truename(userInsurance.getInsured_name());//设置车主姓名
        customer_order.setPhone(userInsurance.getInsured_phone());//设置手机号
        customer_order.setIdentity(userInsurance.getInsured_identity());//设置身份证号
        customer_order.setEmail(userInsurance.getInsured_email());//设置邮箱

        //为被保人信息表添加数据
        Insured_Info insured_info=new Insured_Info();
        insured_info.setInsured_id(UUID.randomUUID().toString());//编号
        insured_info.setInsured_name(userInsurance.getInsured_name());//姓名
        insured_info.setInsured_sex(userInsurance.getInsured_sex());//性别
        insured_info.setInsured_identity(userInsurance.getInsured_identity());//身份证号码
        insured_info.setInsured_phone(userInsurance.getInsured_phone());//电话号
        insured_info.setInsured_email(userInsurance.getInsured_email());//邮箱
        insured_info.setInsured_bank_card(userInsurance.getInsured_bank_card());//银行卡号
        insured_info.setInsured_address(userInsurance.getInsured_address());//地址
        insured_info.setOrder_id(order_id);//性别

        System.out.println("客户编号"+customer_order.getCust_id());

        //获取客户信息
        Customer customer = customerClient.queryCustomerById(customer_order.getCust_id());

        //为投保人信息表添加数据
        Policy_Holder_Info policy_holder_info=new Policy_Holder_Info();
        policy_holder_info.setHolder_id(UUID.randomUUID().toString());//编号
        policy_holder_info.setHolder_truename(customer.getCust_truename());//姓名
        policy_holder_info.setHolder_identity(customer.getCust_identity());//身份证号
        policy_holder_info.setHolder_phone(customer.getCust_phone());//电话
        policy_holder_info.setOrder_id(order_id);//投保订单编号

        //为车辆信息表添加数据
        Car car=new Car();
        car.setCar_id(UUID.randomUUID().toString());//编号
        car.setCar_number(userInsurance.getCar_number());//车牌号
        car.setCar_vin(userInsurance.getCar_vin());//车架号
        car.setCar_engine_number(userInsurance.getCar_engine_number());//发动机号
        car.setManufacturer(userInsurance.getManufacturer());//制造商
        car.setGuiding_price(userInsurance.getGuiding_price());//新车购置价
        car.setSale_name(userInsurance.getSale_name());//排量
        car.setCar_color(userInsurance.getCar_color());//车身颜色
        car.setCar_purchase_date(userInsurance.getCar_purchase_date());//购买日期
        car.setCar_use_nature(userInsurance.getCar_use_nature());//车辆使用性质
        car.setCar_first_register_date(userInsurance.getCar_first_register_date());//初次登记日期
        car.setCar_transfer(userInsurance.getCar_transfer());//车辆是否过户{0：没有过户，1：过户}
        car.setCar_type(userInsurance.getCar_type());//车辆种类
        car.setCar_driving_license_type(userInsurance.getCar_driving_license_type());//车辆行驶证类型
        car.setSeat_num(userInsurance.getSeat_num());//核定载客人数
        car.setCar_weight(userInsurance.getCar_weight());//整备质量（也叫空车重量）
        car.setCar_carry_passenger_weight(userInsurance.getCar_carry_passenger_weight());//核定载客质量
        car.setCar_place_of_origin(userInsurance.getCar_place_of_origin());//车辆产地（进口，国产）
        car.setCar_cust_id(customer_order.getCust_id());//所属客户编号，对应客户信息表的编号
        car.setFuel_type(userInsurance.getFuel_type());//燃油类型
        car.setBrand_name(userInsurance.getBrand_name());//品牌名称
        car.setOrder_id(order_id);//所属投保订单编号


        //将险种项表信息录入数据库
        for(Type_Of_Insurance_Item item : list){
            item.setItem_id(UUID.randomUUID().toString());//编号
            item.setOrder_id(order_id);
//            type_of_insurance_itemMapper.insert(item);
        }
        //将客户订单数据存入数据库
//        customer_orderMapper.insert(customer_order);
        //将被保人信息存入数据库
//        insured_infoMapper.insert(insured_info);
        //将投保人信息录入数据库
//        policy_holder_infoMapper.insert(policy_holder_info);
        //将车辆信息录入数据库
//        carMapper.insert(car);

        System.out.println(order_id);

        return order_id;
    }
}
