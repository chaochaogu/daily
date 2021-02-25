package com.chaochaogu.daily.utils.responsibility.parse.time;

/**
 * 解析普通格式时间
 *
 * @author chaochao Gu
 * @date 2021/2/25
 */
public class NormalDateTimeHandler extends AbstractHandler {

    public NormalDateTimeHandler() {
        super(DateTimePatternEnum.NORMAL.pattern());
    }
}
