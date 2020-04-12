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



@Table(name = "damage_of_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer damage_of_goods_id;//定损编号
    private String  property_name;//损失财产名称
    private String  owner;//物主
    private String  phone;//联系方式
    private String  location;//查勘地点
    private String  loss_description;//损失描述
    private String  fixed_loss_remarks;//定损备注
    private String  emp_id;//定损员编号，对应员工表的编号
    private String  schedule_id;//调度编号，对应调度表的编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   submit_time;//定损提交时间
    private  String  instance_id;//流程实例编号









}
