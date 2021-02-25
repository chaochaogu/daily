package com.chaochaogu.daily.utils.responsibility.parse.time;

/**
 * 解析UTC时间
 *
 * @author chaochao Gu
 * @date 2021/2/25
 */
public class UTCDateTimeHandler extends AbstractHandler {

    public UTCDateTimeHandler() {
        super(DateTimePatternEnum.UTC.pattern());
    }
}
