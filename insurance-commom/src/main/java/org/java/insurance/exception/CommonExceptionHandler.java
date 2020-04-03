package org.java.insurance.exception;


import org.java.insurance.enums.ShoppingEnum;
import org.java.insurance.ov.ExceptionResult;
import org.java.insurance.enums.ShoppingEnum;
import org.java.insurance.ov.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 */

@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 该方法，处理服务中，产生的运行时异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(ShoppingException ex){
        //获得ShoppingException中的枚举属性
        ShoppingEnum shoppingEnum = ex.getShoppingEnum();

        //构建一个ExceptionResult对象，返回异常信息
        return ResponseEntity.status(shoppingEnum.getCode()).body(new ExceptionResult(shoppingEnum));
    }

}
