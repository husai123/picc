package org.java.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 险种表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TYPE_OF_INSURANCE")
public class Type_Of_Insurance {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String insurance_id;//'险种编号'

    private String insurance_name;//'险种名称'

    private String insurance_introduce;//'险种介绍'
}
