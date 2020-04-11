package org.java.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 投保人信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "POLICY_HOLDER_INFO")
public class Policy_Holder_Info {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String holder_id;//'投保人信息编号'

    private String holder_truename;//投保人姓名

    private String holder_identity;//投保人身份证号码

    private String holder_phone;//投保人联系电话

    private String order_id;//所属投保订单编号

    private String policy_id;//所属保单编号
}
