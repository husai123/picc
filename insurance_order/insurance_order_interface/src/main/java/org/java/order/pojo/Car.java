package org.java.order.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAR")
public class Car implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String car_id;//'车辆编号'

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

    @Pattern(regexp = "0|1",message = "车辆是否过户：没有过户: 1,过户: 0")
    private String car_transfer;//车辆是否过户{0：没有过户，1：过户}

    private String car_type;//车辆种类

    private String car_driving_license_type;//车辆行驶证类型

    private Integer seat_num;//核定载客人数

    private Double car_weight;//整备质量（也叫空车重量）

    private Double car_carry_passenger_weight;//核定载客质量

    private String car_place_of_origin;//车辆产地（进口，国产）

    private String car_cust_id;//所属客户编号，对应客户信息表的编号

    private String fuel_type;//燃油类型

    private String brand_name;//品牌名称

    private String order_id;//所属投保订单编号

}
