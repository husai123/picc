package org.java.insurance.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 封装异常的枚举类
 */


@NoArgsConstructor
@Getter
@AllArgsConstructor
public enum InsuranceEnum {
    //此处，相当于带参数的构造方法
    TYPE_OF_INSURANCE_LIST_No_EXISTS(404,"险种列表不存在");


    private  int code;//状态码
     private  String   msg;//异常原因

}
