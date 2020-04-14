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
    TYPE_OF_INSURANCE_LIST_No_EXISTS(404,"险种列表不存在"),




             BRAND_ADD_ERROR(404,"销案新增失败"),
            BRAND_REMOVE_ERROR(404,"销案删除失败"),
            BRAND_LIST_NOT_FOUND(404,"销案列表不存在"),
            BRAND_UPDATE_ERROR(404,"销案修改失败"),



            GOODS_LIST_NOT_FOUND(404,"物损定损不存在"),
            GOODS_REMOVE_ERROR(404,"物损定损删除失败"),
            GOODS_ADD_ERROR(404,"物损定损新增失败"),
            GOODS_UPDATE_ERROR(404,"物损定损修改失败"),



            Damage_LIST_NOT_FOUND(404,"人伤定损不存在"),
            DAMAGE__REMOVE_ERROR(404,"人伤定损删除失败"),
            DAMAGE_ADD_ERROR(404,"人伤定损新增失败"),
            DAMAGE_UPDATE_ERROR(404,"人伤定损修改失败"),


            Robbery_LIST_NOT_FOUND(404,"盗抢定损不存在"),
            Robbery__REMOVE_ERROR(404,"盗抢定损删除失败"),
            Robbery_ADD_ERROR(404,"盗抢定损新增失败"),
            Robbery_UPDATE_ERROR(404,"人伤定损修改失败"),



            VEHICLE_LIST_NOT_FOUND(404,"车辆定损不存在"),
            VEHICLE__REMOVE_ERROR(404,"车辆定损删除失败"),
            VEHICLE_ADD_ERROR(404,"车辆定损新增失败"),
            VEHICLE_UPDATE_ERROR(404,"人伤定损修改失败");




    private  int code;//状态码
     private  String   msg;//异常原因

}
