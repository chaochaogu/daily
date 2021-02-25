package com.chaochaogu.daily.utils.responsibility.parse.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author chaochao Gu
 * @date 2021/2/25
 */
public abstract class AbstractHandler {

    private final DateTimeFormatter DTF;

    public AbstractHandler(String pattern) {
        this.DTF = DateTimeFormat.forPattern(pattern);
    }

    private AbstractHandler nextHandler;

    /**
     * 设置下一个处理者是谁
     *
     * @param nextHandler
     */
    public void setNext(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected DateTime parseDateTime(String text) {
        return DTF.parseDateTime(text);
    }

    public DateTime handleTime(String text) {
        DateTime resp;
        try {
            resp = this.parseDateTime(text);
        } catch (Exception e) {
            if (this.nextHandler != null) {
                resp = this.nextHandler.handleTime(text);
            } else {
                throw new RuntimeException("no handler to handle");
            }
        }
        return resp;
    }
}
