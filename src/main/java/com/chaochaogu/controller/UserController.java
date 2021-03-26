package com.chaochaogu.controller;

import com.alibaba.excel.EasyExcel;
import com.chaochaogu.model.*;
import com.chaochaogu.service.IAddressService;
import com.chaochaogu.service.IUserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/queryById/{id}")
    public User queryUserById(@PathVariable("id") Integer id) {
        log.info("web query user by id {}", id);
        return userService.queryUserById(id);
    }

    @GetMapping("/multi")
    public String testMultiDatasource() {
        User user = userService.queryUserById(1);
        log.info("user in db1:{}", user);
        Address address = addressService.queryById(1L);
        log.info("address in db2:{}", address);
        return "success";
    }

    @PostMapping("/save")
    public boolean saveUser(@RequestBody User user) {
        log.info("web save user {}", user);
        return userService.saveUser(user);
    }

    @RequestMapping("deleteById/{id}")
    public boolean deleteUserById(@PathVariable("id") Integer id) {
        log.info("web delete user by id {}", id);
        return userService.deleteUserById(id);
    }

    @PostMapping("/import")
    public String importUser(MultipartFile file) throws Exception {
        List<UserImportVO> list = EasyExcel.read(file.getInputStream(), UserImportVO.class, new UserImportListener()).sheet().doReadSync();
        for (UserImportVO importUser : list) {
            User user = User.builder().build();
            BeanUtils.copyProperties(importUser, user);
            userService.saveUser(user);
        }
        return "success";
    }

    @GetMapping("/export")
    public void exportUser(HttpServletResponse response) throws Exception {
        User user = userService.queryUserById(1);
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), UserExportVO.class).sheet("模板").doWrite(Lists.newArrayList(user));
    }
}
