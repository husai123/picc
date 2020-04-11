package org.java.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * 险种项表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TYPE_OF_INSURANCE_ITEM")
public class Type_Of_Insurance_Item {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String item_id;//'险种项编号'

    private String insurance_id;//'险种编号，对应险种表的编号'

    private Double premium;//'保费'

    private Double insured_amount;//'保额'

    private String order_id;//所属投保订单，对应投保订单表的编号

    private String policy_id;//所属保单，对应保单表的编号

    @Pattern(regexp = "0|1",message = "是否不计免赔：是: 1,否: 0")
    private String is_no_deductible;//是否不计免赔：是: 1,否: 0


}
