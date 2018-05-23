/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.*;
import java.io.IOException;
import java.net.*;
import java.net.URL;

/**
 *
 * @author mighty
 */
public class Network {
    URL location;
    String link;
    String method;
    HttpURLConnection conn;
    public Network(String link){
        this.link = link; 
    }
    public Network(String link, String method) {
//        this.location = new URL(link);
        this.method = method;
       
    }
    public String connect() throws IOException{
        return link;
    }
}
