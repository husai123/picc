package org.java.insurance.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "case_closed")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  Integer  case_closed_id; //销案编号
    private  String  emp_id;     //销案员编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date    case_closed_time; //销案时间
    private  String  case_closed_reason;//销案原因
    private  String  case_closed_comment;//销案备注
    private  String  compensate_case_id;//销案对应赔案
}
