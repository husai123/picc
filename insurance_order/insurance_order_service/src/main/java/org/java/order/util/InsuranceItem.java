package org.java.order.util;


import org.java.order.pojo.Type_Of_Insurance;
import org.java.order.pojo.Type_Of_Insurance_Item;

/**
 * 险种信息表
 */
public class InsuranceItem {

    private String item_id;//'险种项编号'

    private String insurance_id;//'险种编号，对应险种表的编号'

    private Double premium;//'保费'

    private Double insured_amount;//'保额'

    private String order_id;//所属投保订单，对应投保订单表的编号

    private String policy_id;//所属保单，对应保单表的编号

    private String is_no_deductible;//是否不计免赔：是: 1,否: 0

    private String insurance_name;//'险种名称'


    public InsuranceItem(Type_Of_Insurance type_of_insurance, Type_Of_Insurance_Item type_of_insurance_item) {
        this.item_id = type_of_insurance_item.getItem_id();
        this.insurance_id = type_of_insurance_item.getInsurance_id();
        this.premium = type_of_insurance_item.getPremium();
        this.insured_amount = type_of_insurance_item.getInsured_amount();
        this.order_id = type_of_insurance_item.getOrder_id();
        this.policy_id = type_of_insurance_item.getPolicy_id();
        this.is_no_deductible = type_of_insurance_item.getIs_no_deductible();
        this.insurance_name = type_of_insurance.getInsurance_name();
    }


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
