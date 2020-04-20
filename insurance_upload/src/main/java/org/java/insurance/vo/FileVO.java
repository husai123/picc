package org.java.insurance.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  封装文件上传的以后的返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVO {

    private int code;//状态码： 1：成功  0：失败
    private String msg;//文件上传成功或失败的提示信息
    private String data;//文件上传成功后的保存路径
}
