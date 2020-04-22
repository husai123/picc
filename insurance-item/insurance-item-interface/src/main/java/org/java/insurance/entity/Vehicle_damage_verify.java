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

@Table(name = "vehicle_damage_verify")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle_damage_verify implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String Verify_id;//车辆定损核损编号
    private Double Rescue_price;//核损施救费
    private String Verify_loss_discount;//核损折扣残值
    private String Is_adopt;//核损是否通过{0：不通过，1：通过}
    private String Verify_comment;//核损备注
    private Double Verify_material_fee;//核损意见材料费
    private Double Verify_labor_costs;//核损意见人工费
    private Double Verify_manager_fee;//核损意见管理费
    private Double Verify_residual_value;//核损意见残值
    private Double Verify_sum_price;//计算好的总额
    private String Vehilce_damage_id;//所属车辆定损，对应车辆定损表的编号
    private String Emp_id;//核损员编号，对应员工表的编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Verify_time;//核损时间
    private String Instance_id;//流程实例编号
}
