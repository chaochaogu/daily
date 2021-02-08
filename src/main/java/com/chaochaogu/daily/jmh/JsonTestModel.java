package com.chaochaogu.daily.jmh;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chaochao Gu
 * @date 2021/1/4
 */
@Data
public class JsonTestModel implements Serializable {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Boolean flag;
    private int threads;
    private int shardingIndex;
}
