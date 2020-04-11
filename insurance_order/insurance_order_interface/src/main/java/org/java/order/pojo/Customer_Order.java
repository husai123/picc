package org.java.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 客户投保订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER_ORDER")
public class Customer_Order {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String order_id;//'订单编号'

    @Pattern(regexp = "0|1",message = "是否购买交强险：是: 1,否: 0")
    private String is_pay_jiaoqiangxian;//是否购买交强险(1：是，0：否)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jiaoqiangxian_start_date;//交强险起保时间

    @Pattern(regexp = "0|1",message = "是否缴纳车船税：是: 1,否: 0")
    private String is_chechuanshui;//是否缴纳车船税(1：是，0：否)

    @Pattern(regexp = "0|1",message = "是否购买商业险：是: 1,否: 0")
    private String is_pay_shangyexian;//是否购买商业险(1：是，0：否)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shangyexian_start_date;//商业险起保时间

    private String toubaochengshi;//投保城市

    private String car_truename;//车主姓名

    private String phone;//手机号

    private String identity;//身份证号

    private String email;//邮箱

    private String status;//订单状态{0：待提交，1：待报价，2：待完善，3：待支付，4：待审核，5：审核不通过，修改资料，6：交易成功，7：已取消，8：退款中，9：已退款}

    private String cust_id;//客户编号

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inquiry_time;//询价时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pay_time;//支付时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date close_time;//交易关闭时间

    private String instance_id;//流程实例编号

}
