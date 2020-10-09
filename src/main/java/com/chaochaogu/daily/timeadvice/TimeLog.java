package com.chaochaogu.daily.timeadvice;

import java.lang.annotation.*;

/**
 * 日志耗时注解
 *
 * @author chaochao Gu
 * @date 2020-03-21 12:37 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeLog {

    /**
     * 是否开启超时提醒
     */
    boolean openHandle() default false;

    /**
     * 超时提醒阀值 单位 ms
     */
    long limit() default Long.MAX_VALUE;

    /**
     * 是否显示参数
     */
    boolean showArgs() default false;

    /**
     * 方法名(默认方法全路径)
     */
    String methodName() default "";

}
