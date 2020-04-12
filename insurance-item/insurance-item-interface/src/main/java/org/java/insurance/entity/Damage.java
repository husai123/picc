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

@Table(name = "human_injury_damage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Damage implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
     private  Integer human_injury_damage_id;//人伤定损编号
     private  String name;//病人姓名
     private  String sex;//性别
     private  Integer  age;//年龄
     private  String  visiting_hospital;//就诊医院
     private  String  degree_of_injury;//伤势程度
     private  String  disability_grade;//伤残等级
     private  String  category_of_injury;//伤情类别
     private  String  contact_information;//联系情况
     private  String  schedule_id;//调度表
     private  String  car_number;//车辆车牌号
     private  String  fixed_loss_remarks;//定损备注
     private  String   emp_id;//定损员编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private  Date    submit_time;//定损提交时间
     private  String  instance_id;//流程实例编号


}
