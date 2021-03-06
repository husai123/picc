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


@Table(name = "ROBBERY_DAMAGE_VERIFY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Robbery_verify implements Serializable{
     @Id
     @KeySql(useGeneratedKeys = true) private  String Verify_id;//核损编号
     private  String Is_adopt;//核损是否通过{0：不通过，1：通过}
     private  String Verify_comment;//核损备注
     private  String  Robbery_damage_id;//所属盗损定损
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date Verify_time;//核损时间
     private  String  Emp_id;//核损员编号，对应员工表的编号
     private  String Instance_id;//流程实例编号
}
