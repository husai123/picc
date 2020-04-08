package org.java.customer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户信息表，记录客户基本信息，用于登录和辨认
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String cust_id;//'客户编号'

    @Length(min = 2,message = "姓名的长度必须大于等于 2 位")
    private String cust_truename;//'客户真实姓名'

    @Pattern(regexp = "0|1",message = "客户性别只能是0：男，1：女")
    private String cust_sex;//'客户性别{0：男，1：女}'
    private String cust_identity;//'客户身份证号码'

    @Pattern(regexp = "^1[356789]\\d{9}$",message = "电话号码格式错误")
    private String cust_phone;//'客户移动电话'


    private String cust_email;//'客户电子邮箱'

    @JsonIgnore//在序列化时，忽略当前属性
    @Length(min = 6,message = "密码的长度必须大于等于 6 ")
    private String cust_password;//'登陆密码'
    private String cust_bank_card;//'客户开户银行卡号'
    private String cust_head_img;//'客户头像'
    private String cust_address;//'客户详细地址'

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cust_birthday;//'客户出生日期'

    @JsonIgnore//在序列化时，忽略当前属性
    private String salt;//加密使用的盐

    public void setCust_birthday(String cust_birthday) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.cust_birthday = sf.parse(cust_birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //    CUST_ID VARCHAR(36) NOT NULL   COMMENT '客户编号' ,
//    CUST_TRUENAME VARCHAR(32)    COMMENT '客户真实姓名' ,
//    CUST_SEX VARCHAR(1)    COMMENT '客户性别{0：男，1：女}' ,
//    CUST_IDENTITY VARCHAR(18)    COMMENT '客户身份证号码' ,
//    CUST_PHONE VARCHAR(32)    COMMENT '客户移动电话' ,
//    CUST_EMAIL VARCHAR(32)    COMMENT '客户电子邮箱' ,
//    CUST_PASSWORD VARCHAR(32)    COMMENT '登陆密码' ,
//    CUST_BANK_CARD VARCHAR(32)    COMMENT '客户开户银行卡号' ,
//    CUST_HEAD_IMG varchar(1000)    COMMENT '客户头像' ,
//    CUST_ADDRESS VARCHAR(512)    COMMENT '客户详细地址' ,
//    CUST_BIRTHDAY DATE    COMMENT '客户出生日期'

}
