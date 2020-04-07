package org.java.login.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "EMPLOYEE_ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginPojo implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private  String   emp_id;//用户编号

    @Length(min = 2,message = "姓名的长度必须大于等于 2 位")
    private  String   username;//员工用户名

    @JsonIgnore//在序列化时，忽略当前属性
    @Length(min = 6,message = "密码的长度必须大于等于 6 ")
    private  String   password;//员工密码

    @JsonIgnore//在序列化时，忽略当前属性
    private  String   salt;
}
