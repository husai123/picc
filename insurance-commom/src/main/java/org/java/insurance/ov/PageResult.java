package org.java.insurance.ov;

import lombok.Data;

import java.util.List;

/**
 *  该类，用于保存分页的结果
 */
@Data
public class PageResult<T>{
    private List<T> data;//保存分页查询到的结果
    private int code;//状态码，0：表示正常
    private String msg;//数据无法加载时，显示的消息内容
    private long count;//查询到的数据总数


    private Integer pageNum;//当前页
    private Integer maxPage;//最大页

}
