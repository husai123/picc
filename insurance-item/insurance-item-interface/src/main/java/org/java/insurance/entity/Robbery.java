package org.java.insurance.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



@Table(name = "robbery_damage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Robbery implements Serializable {


    @Id
    @KeySql(useGeneratedKeys = true)
     private Integer robbery_damage_id;// 定损编号
     private String car_number;//车牌号码
     private String license_plate_color;//车牌颜色
     private String car_brand;//车辆品牌
     private String car_type;//车型
     private String pay_price;//新车购置价
     private Integer driving_kilometre;//已行驶公里数
     private Integer service_life;//实际使用年限
     private String fixed_loss_comment;//定损备注
     private  String emp_id;//定损员编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date submit_time;//定损提交时间
     private String schedule_id;//调度表
     private  String instance_id;//流程实例编号


}
