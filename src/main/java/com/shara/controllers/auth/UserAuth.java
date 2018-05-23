/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.controllers.auth;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static com.shara.Shara.CSRF_TOKEN;
import com.shara.models.User;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author mighty
 */
public class UserAuth {
    public static HashMap<String, String> headers = new HashMap<>();
    public static void initHeaders(){
        headers.putIfAbsent("Accept", "application/json");
//        headers.putIfAbsent("Content-Type", "application/json");
    }
    public static User register(HashMap<String, Object> userInfo){
        initHeaders();
        try {
            HttpResponse<User> userReq = Unirest.post("http://127.0.0.1:8000/api/register")
                    .headers(headers)
                    .fields(userInfo).asObject(User.class);
            return userReq.getBody();
        } catch (UnirestException ex) {
            System.err.print(ex);
            return null;
        }
    }
    public static User login(HashMap<String, Object> userInfo){
        initHeaders();
        try{
            HttpResponse<User> userReq = Unirest.post("http://127.0.0.1:8000/api/login")
                    .headers(headers)
                    .fields(userInfo).asObject(User.class);
            return userReq.getBody();
        }catch(UnirestException ex){
            System.err.print(ex);
            return null;
        }
    }
    public static JsonNode logout(){
        try{
            HttpResponse<JsonNode> userReq = Unirest.post("http://127.0.0.1:8000/api/logout").asJson();
            return userReq.getBody();
        }catch(UnirestException ex){
            return null;
        }
    }
    public static HashMap<String, Object> home(Integer id){
        HashMap<String, Object> response = new HashMap<>();
        try{
            HttpResponse<User> user = Unirest.get("http/127.0.0.1/mobile/{id}").routeParam("id", id.toString()).asObject(User.class);
            response.put("user", user);
            return response;
        }catch(UnirestException ex){
            return null;
        }
    }
}
