package org.java.insurance.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private  String  case_closed_id; //销案编号
    private  String  emp_id;     //销案员编号
    private  Date    case_closed_time; //销案时间
    private  String  case_closed_reason;//销案原因
    private  String  case_closer_comment;//销案备注
    private  String  compensate_case_id;//销案对应赔案
}
