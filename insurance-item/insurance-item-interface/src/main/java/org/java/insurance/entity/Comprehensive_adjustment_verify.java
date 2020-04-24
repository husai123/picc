package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "COMPREHENSIVE_ADJUSTMENT_VERIFY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprehensive_adjustment_verify {
    @Id
    @KeySql(useGeneratedKeys = true) private  String Verify_id;//核赔编号
    private  String Is_adopt;//是否通过{0：不通过，1：通过}
    private  String Verify_comment;//核损备注
    private  String  Adjustment_id;//所属全面理算编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Verify_time;//核损时间
    private  String  Emp_id;//核损员编号，对应员工表的编号
    private Double Cross_strength_sum;//交强赔款合计
    private Double Business_sum;//商业赔款合计
    private Double Sum;//赔款总额
    private  String Instance_id;//流程实例编号
}
