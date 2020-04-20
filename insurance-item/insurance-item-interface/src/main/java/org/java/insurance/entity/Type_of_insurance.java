package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "type_of_insurance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type_of_insurance implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  String Insurance_id;//险种编号
    private  String Insurance_name;//险种名称
    private  String Insurance_introduce;//险种介绍
}
