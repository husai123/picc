package org.java.insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.java.insurance.enums.InsuranceEnum;




@AllArgsConstructor //生成，带参数的构造方法
@Data
public class InsuranceException extends RuntimeException{

    private InsuranceEnum insuranceEnum;//枚举类型的属性
}
