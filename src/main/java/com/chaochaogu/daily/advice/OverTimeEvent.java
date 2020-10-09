package com.chaochaogu.daily.advice;

import lombok.Builder;
import lombok.Data;

/**
 * 方法执行超时事件
 *
 * @author chaochao Gu
 * @date 2020-03-21 3:27 下午
 */
@Data
@Builder
public class OverTimeEvent {

    /**
     * 方法全路径
     */
    private String methodName;

    /**
     * 耗时
     */
    private Long elapsed;

    /**
     * 方法参数
     */
    private String params;

}
