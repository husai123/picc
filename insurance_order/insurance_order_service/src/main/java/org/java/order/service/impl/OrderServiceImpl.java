package org.java.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.customer.pojo.Customer;
import org.java.insurance.enums.InsuranceEnum;
import org.java.insurance.exception.InsuranceException;
import org.java.insurance.ov.PageResult;
import org.java.insurance.util.JsonUtils;
import org.java.order.dao.*;
import org.java.order.feign.CustomerClient;
import org.java.order.pojo.*;
import org.java.order.service.OrderService;
import org.java.order.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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


    /**
     * 险种信息
     */
    private Type_Of_InsuranceMapper type_of_insuranceMapper;



    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;


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
        String order_id = OrderCodeFactory.getOrderCode(new Long(10));

        customer_order.setOrder_id(order_id);//设置订单编号
        customer_order.setStatus("0");//设置订单状态 : 待提交
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


        /*********************************工作流***************************************/

        //将userId设置为任务的发起者
        identityService.setAuthenticatedUserId(customer_order.getCust_id());

        /**************第一个任务：启动流程实例 ******************/

        //指定流程定义的key
        String processDefinitionKey= ResourcesUtil.getValue("/process","processDefinitionKey");

        //启动流程实例
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, order_id);//流程定义的key,业务主键

        //将流程实例编号存入询价订单信息中
        customer_order.setInstance_id(instance.getProcessInstanceId());//流程实例id

        /*****************************************************************************/

        //将险种项表信息录入数据库
        for(Type_Of_Insurance_Item item : list){
            item.setItem_id(UUID.randomUUID().toString());//编号
            item.setOrder_id(order_id);
            type_of_insurance_itemMapper.insert(item);
        }
        //将客户订单数据存入数据库
        customer_orderMapper.insert(customer_order);
        //将被保人信息存入数据库
        insured_infoMapper.insert(insured_info);
        //将投保人信息录入数据库
        policy_holder_infoMapper.insert(policy_holder_info);
        //将车辆信息录入数据库
        carMapper.insert(car);

        System.out.println(order_id);

        return order_id;
    }




    /**
     * 根据  客户编号  查询所有该客户的询价订单
     * 订单的状态为：0：待提交，1：待报价 ，2：待完善，3：待支付
     */
    @Override
    public PageResult<InquiryOrder> queryInquiry(String cust_id, Integer page, Integer limit) {
//创建一个Example对象，封装查询条件
        Example example  = new Example(Customer_Order.class);

        //通过exmaple封装查询条件
        Example.Criteria criteria = example.createCriteria();

        //判断是否有条件
        if(!StringUtils.isEmpty(cust_id)){
            //指定查询条件
            criteria.andEqualTo("cust_id",cust_id);
        }

        List list=new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("0");

        //订单的状态为：0：待提交，1：待报价 ，2：待完善，3：待支付
        criteria.andIn("status",list);

        PageHelper.startPage(page,limit);

        List<Customer_Order> customer_orders = customer_orderMapper.selectByExample(example);

        //判断该客户有没有询价订单
        if(CollectionUtils.isEmpty(customer_orders)){
            //没有数据，返回自定义异常
            throw new InsuranceException(InsuranceEnum.CUSTOMER_ORDER_NOT_LIST);
        }

        //创建类保存订单信息
        List<InquiryOrder> inquiryOrderList=new ArrayList<>();

        //将车辆信息数据存放到  inquiryOrderList  集合中
        for (Customer_Order order : customer_orders){

            //获取车辆信息
            Car car=new Car();
            car.setOrder_id(order.getOrder_id());
            Car car1 = carMapper.selectOne(car);

            //获取险种信息
            Type_Of_Insurance_Item type_of_insurance_item=new Type_Of_Insurance_Item();
            type_of_insurance_item.setOrder_id(order.getOrder_id());
            List<Type_Of_Insurance_Item> Insurance_Item = type_of_insurance_itemMapper.select(type_of_insurance_item);

            List<InsuranceItem> InsuranceItems=new ArrayList<>();

            for (Type_Of_Insurance_Item type_of_insurance_item1 : Insurance_Item){
                //获取险种项名称
                Type_Of_Insurance type_of_insurance = type_of_insuranceMapper.selectByPrimaryKey(type_of_insurance_item1.getInsurance_id());

                InsuranceItem insuranceItem=new InsuranceItem(type_of_insurance,type_of_insurance_item);

                InsuranceItems.add(insuranceItem);
            }


            Insured_Info insured_info=new Insured_Info();
            insured_info.setOrder_id(order.getOrder_id());
            Insured_Info insured_info1 = insured_infoMapper.selectByPrimaryKey(insured_info);

            InquiryOrder inquiryOrder=new InquiryOrder();
            inquiryOrder.setCustomer_order(order);//将询价订单信息存入类中
            inquiryOrder.setCar(car1);//将车辆信息存入类中
            inquiryOrder.setInsured_info(insured_info1);//将被保人信息存入类中
            inquiryOrder.setInsuranceItem(InsuranceItems);//将险种信息存入类中

            inquiryOrderList.add(inquiryOrder);
        }


        PageInfo<InquiryOrder> pageInfo=new PageInfo<>(inquiryOrderList);



        //封装成PageResult
        PageResult pageResult = new PageResult();
        pageResult.setData(list);
        pageResult.setCode(0);//正常
        pageResult.setCount(pageInfo.getTotal());//数据总数
        pageResult.setPageNum(pageInfo.getPageNum());//当前页
        pageResult.setMaxPage(pageInfo.getPages());//最大页

        return pageResult;
    }



    /**
     * 提交订单询价
     * 工作流向前推进一步 进入报价员报价
     */
    @Override
    @Transactional
    public void submit_inquiry(String order_id) {
        //通过订单编号获取订单信息
        Customer_Order customer_order = customer_orderMapper.selectByPrimaryKey(order_id);

        //创建任务查询接口
        TaskQuery taskQuery = taskService.createTaskQuery();
        //指定要查询谁的任务
        //将客户编号放入查询
        taskQuery.taskAssignee(customer_order.getCust_id());
        //查询，得到任务的集合 -------task中，只包含了工作流的信息，没有业务数据，需要把对应的业务数据加载出来
        List<Task> tasklist = taskQuery.list();

        for(Task t:tasklist){
            //找到需要提交的任务
            if(t.getProcessInstanceId().equals(customer_order.getInstance_id())){
                taskService.complete(t.getId());//将任务编号放到提交方法中
                break;
            }
        }

    }
}
