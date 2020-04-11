package org.java.insurance.ov;

import lombok.Data;
import org.java.insurance.enums.InsuranceEnum;

@Data
public class ExceptionResult {

    private int code;//状态码
    private String msg;//异常消息
    private Long timestamp;//时间戳

    public ExceptionResult(InsuranceEnum shoppingEnum){
        this.code = shoppingEnum.getCode();
        this.msg = shoppingEnum.getMsg();
        this.timestamp= System.currentTimeMillis();//系统时间
    }



}
