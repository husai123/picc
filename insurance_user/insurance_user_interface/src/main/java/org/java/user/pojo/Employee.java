package org.java.user.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 员工信息表，用于登录注册
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {


      @Id
      @KeySql(useGeneratedKeys = true)
      private  Long emp_id;  //员工编号

      @Length(min = 2,message = "姓名的长度必须大于等于 2 位")
      private  String username;//员工名称

      @JsonIgnore//在序列化时，忽略当前属性
      @Length(min = 6,message = "密码的长度必须大于等于 6 ")
      private  String password; //员工密码

      @Pattern(regexp = "^1[356789]\\d{9}$",message = "电话号码格式错误")
      private  String phone; //员工电话

      @JsonIgnore//在序列化时，忽略当前属性
      private String salt;//加密使用的盐



}
