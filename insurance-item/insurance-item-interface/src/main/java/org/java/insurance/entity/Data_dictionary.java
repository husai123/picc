package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "data_dictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Data_dictionary {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  Integer Id;//编号
    private  String Type;//类型
    private  String Show_value;//显示值
    private  Integer Hide_value;//隐藏值
}
