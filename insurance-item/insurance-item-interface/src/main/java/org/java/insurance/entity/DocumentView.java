package org.java.insurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentView {
    private  String Documents_id;//单证编号
    private  String Documents_name;//单证名称
    private  String Insurance_id;//险种类别
    private  String Insurance_name;//险种名称
    private  String Type_id;//所属单证类型
    private  String Type_name;//所属单证类型名称
    private  String Is_requried;//是否必须{0：否，1：是}
    private  String Is_requriedView;//显示时的是否必须
}
