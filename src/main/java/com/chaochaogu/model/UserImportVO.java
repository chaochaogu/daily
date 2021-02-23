package com.chaochaogu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author chaochao Gu
 * @date 2021/2/20
 */
@Data
public class UserImportVO {

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("电话")
    private String telephone;

    @ExcelProperty("状态")
    private Integer status;
}
