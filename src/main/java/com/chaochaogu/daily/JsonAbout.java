package com.chaochaogu.daily;

import com.chaochaogu.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chaochao gu
 * @date 2021/2/2
 */
public class JsonAbout {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = User.builder().id(1).username("gcc").password("333").build();
        System.out.println(objectMapper.writeValueAsString(user));
    }
}
