package org.java.order.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInsurance {

    private String insured_name;//被保人姓名

    private String insured_sex;//被保人性别{0：男，1：女}

    private String insured_identity;//被保人身份证号码

    private String insured_phone;//被保人移动电话

    private String insured_email;//被保人邮箱

    private String insured_bank_card;//被保人银行卡号

    private String insured_address;//被保人详细地址



    private String toubaochengshi;//投保城市

    private String car_number;//车牌号

    private String car_vin;//车架号

    private String car_engine_number;//发动机号

    private String manufacturer;//制造商

    private Double guiding_price;//新车购置价

    private String sale_name;//排量

    private String car_color;//车身颜色

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date car_purchase_date;//购买日期

    private String car_use_nature;//车辆使用性质

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date car_first_register_date;//初次登记日期

    private String car_transfer;//车辆是否过户{0：没有过户，1：过户}

    private String car_type;//车辆种类

    private String car_driving_license_type;//车辆行驶证类型

    private Integer seat_num;//核定载客人数

    private Double car_weight;//整备质量（也叫空车重量）

    private Double car_carry_passenger_weight;//核定载客质量

    private String car_place_of_origin;//车辆产地（进口，国产）

    private String fuel_type;//燃油类型

    private String brand_name;//品牌名称


    public String getToubaochengshi() {
        return toubaochengshi;
    }

    public void setToubaochengshi(String toubaochengshi) {
        this.toubaochengshi = toubaochengshi;
    }

    public String getInsured_name() {
        return insured_name;
    }

    public void setInsured_name(String insured_name) {
        this.insured_name = insured_name;
    }

    public String getInsured_sex() {
        return insured_sex;
    }

    public void setInsured_sex(String insured_sex) {
        this.insured_sex = insured_sex;
    }

    public String getInsured_identity() {
        return insured_identity;
    }

    public void setInsured_identity(String insured_identity) {
        this.insured_identity = insured_identity;
    }

    public String getInsured_phone() {
        return insured_phone;
    }

    public void setInsured_phone(String insured_phone) {
        this.insured_phone = insured_phone;
    }

    public String getInsured_email() {
        return insured_email;
    }

    public void setInsured_email(String insured_email) {
        this.insured_email = insured_email;
    }

    public String getInsured_bank_card() {
        return insured_bank_card;
    }

    public void setInsured_bank_card(String insured_bank_card) {
        this.insured_bank_card = insured_bank_card;
    }

    public String getInsured_address() {
        return insured_address;
    }

    public void setInsured_address(String insured_address) {
        this.insured_address = insured_address;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_vin() {
        return car_vin;
    }

    public void setCar_vin(String car_vin) {
        this.car_vin = car_vin;
    }

    public String getCar_engine_number() {
        return car_engine_number;
    }

    public void setCar_engine_number(String car_engine_number) {
        this.car_engine_number = car_engine_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getGuiding_price() {
        return guiding_price;
    }

    public void setGuiding_price(Double guiding_price) {
        this.guiding_price = guiding_price;
    }

    public String getSale_name() {
        return sale_name;
    }

    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public Date getCar_purchase_date() {
        return car_purchase_date;
    }

    public void setCar_purchase_date(Date car_purchase_date) {
        this.car_purchase_date = car_purchase_date;
    }

    public String getCar_use_nature() {
        return car_use_nature;
    }

    public void setCar_use_nature(String car_use_nature) {
        this.car_use_nature = car_use_nature;
    }

    public Date getCar_first_register_date() {
        return car_first_register_date;
    }

    public void setCar_first_register_date(Date car_first_register_date) {
        this.car_first_register_date = car_first_register_date;
    }

    public String getCar_transfer() {
        return car_transfer;
    }

    public void setCar_transfer(String car_transfer) {
        this.car_transfer = car_transfer;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_driving_license_type() {
        return car_driving_license_type;
    }

    public void setCar_driving_license_type(String car_driving_license_type) {
        this.car_driving_license_type = car_driving_license_type;
    }

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    public Double getCar_weight() {
        return car_weight;
    }

    public void setCar_weight(Double car_weight) {
        this.car_weight = car_weight;
    }

    public Double getCar_carry_passenger_weight() {
        return car_carry_passenger_weight;
    }

    public void setCar_carry_passenger_weight(Double car_carry_passenger_weight) {
        this.car_carry_passenger_weight = car_carry_passenger_weight;
    }

    public String getCar_place_of_origin() {
        return car_place_of_origin;
    }

    public void setCar_place_of_origin(String car_place_of_origin) {
        this.car_place_of_origin = car_place_of_origin;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}
