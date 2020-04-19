package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  String Documents_id;//单证编号
    private  String Documents_name;//单证名称
    private  String Insurance_id;//险种类别
    private  String Type_id;//所属单证类型
    private  String Is_requried;//是否必须{0：否，1：是}
}
