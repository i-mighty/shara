/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.controllers.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author mighty
 */
public class FakerValues {
    public static String fm = "Josiah";
    public static String lm = "Adegboye";
    public static String em = "josadegboye@gmail.com";
    public static String st = "Plateau";
    public static String cy = "Jos";
    public static String pw = "adeola99";
    public static HashMap<String, Object> loginData = new HashMap<>();
    public static HashMap<String, Object> regData = new HashMap<>();
    
    public static HashMap<String, Object> popLogin(){
        HashMap<String, Object> data = new HashMap<>();
        data.putIfAbsent("email", em);
        data.putIfAbsent("password", "secret");
        return data;
    }
    public static HashMap<String, Object> popReg(){
        HashMap<String, Object> data = new HashMap<>();
        data.putIfAbsent("first_name", fm);
        data.putIfAbsent("last_name", lm);
        data.putIfAbsent("email", em);
        data.putIfAbsent("state", st);
        data.putIfAbsent("city", cy);
        data.putIfAbsent("password", "secret");
        data.putIfAbsent("password_confirmation", "secret");
        return data;
    }
    public static void setObjectMapper(){
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                        = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
