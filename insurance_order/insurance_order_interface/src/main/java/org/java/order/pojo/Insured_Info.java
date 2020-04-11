package org.java.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * 被保人信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INSURED_INFO")
public class Insured_Info {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String insured_id;//'被保人信息编号'

    private String insured_name;//被保人姓名

    @Pattern(regexp = "0|1",message = "被保人性别{0：男，1：女}")
    private String insured_sex;//被保人性别{0：男，1：女}

    private String insured_identity;//被保人身份证号码

    private String insured_phone;//被保人移动电话

    private String insured_email;//被保人邮箱

    private String insured_bank_card;//被保人银行卡号

    private String insured_address;//被保人详细地址

    private String order_id;//所属投保订单编号

}
