package com.chaochaogu.daily.timeadvice;

/**
 * 方法执行超时处理器
 *
 * @author chaochao Gu
 * @date 2020-03-21 2:58 下午
 */
public interface OvertimeHandler {

    /**
     * 方法超时处理
     *
     * @param overTimeEvent 超时事件
     */
    void handle(OverTimeEvent overTimeEvent);

}
