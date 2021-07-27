package com.chaochaogu.controller;

import com.chaochaogu.model.PeFundTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaochao Gu
 * @date 2021/7/23
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("/pefund/save")
    public String test(@RequestBody PeFundTable peFundTable){
        log.info("front save pefund, {}", peFundTable.toString());
        System.out.println("123");
        return "success";
    }
}
