package org.java.insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.java.insurance.enums.ShoppingEnum;




@AllArgsConstructor //生成，带参数的构造方法
@Data
public class ShoppingException extends RuntimeException{

    private ShoppingEnum shoppingEnum;//枚举类型的属性
}
