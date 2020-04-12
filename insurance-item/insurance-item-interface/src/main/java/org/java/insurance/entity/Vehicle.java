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



@Table(name = "vehicle_damage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {


    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer vehicle_damage_id;  //车辆定损编号
    private String  repair_depot_name;//修理厂名称
    private String  repair_depot_phone;//修理厂电话
    private String  repair_depot_linkman;//修理厂联系人
    private String  repair_depot_address;//修理厂地址
    private String  fixed_loss_method;//定损方式
    private String  fixed_loss_comment;//定损备注
    private  Integer opinion_material_fee;//定损费
    private String schedule_id;//调度表
    private String emp_id;//定损员编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date   submit_time;//定损提交时间
    private String instance_id;//流程实例编号



}
