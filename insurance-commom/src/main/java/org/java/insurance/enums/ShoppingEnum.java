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
public enum ShoppingEnum {


    SKU_ADD_ERROR(404,"商品新增失败"),
    SKU_LIST_NOT_FOUND(404,"商品列表不存在"),



    BRAND_ADD_ERROR(404,"销案新增失败"),
    BRAND_REMOVE_ERROR(404,"销案删除失败"),
    BRAND_LIST_NOT_FOUND(404,"销案列表不存在"),



    GOODS_LIST_NOT_FOUND(404,"物损定损不存在"),


    Damage_LIST_NOT_FOUND(404,"人伤定损不存在"),


    Robbery_LIST_NOT_FOUND(404,"盗抢定损不存在"),

    VEHICLE_LIST_NOT_FOUND(404,"车辆定损不存在"),



    CATEGORY_LIST_NOT_FOUND(404,"商品列表不存在"),
    NAME_CANNOT_BE_NOT(400,"名称不允许为空"),
    //此处，相当于带参数的构造方法
    PRICE_CANNOT_BE_NOT(400,"价格不允许为空");


    private  int code;//状态码
     private  String   msg;//异常原因

}
