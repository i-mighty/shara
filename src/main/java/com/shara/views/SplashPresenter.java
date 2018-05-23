/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.views;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.control.LifecycleEvent;
import com.gluonhq.charm.glisten.mvc.SplashView;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.shara.Shara;
import static com.shara.views.FontManager.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author mighty
 */
public class SplashPresenter extends GluonPresenter<Shara> {
    
    @FXML private SplashView splash;
    @FXML private Label appName;        
    @FXML private Label loadingText;
    
    public void initialize(){
        appName.setFont(getFont(LEMONADA, 20));
        splash.setShowTransitionFactory(FadeInTransition::new);
        splash.setOnShown((LifecycleEvent e) -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished((ActionEvent f) -> {
                loadingText.setText("Starting");
//                connectTask();
                splash.hideSplashView();
            });
            pause.play();
        });
        //Set stylesheet per platform
        if(Platform.isAndroid()){
            splash.getStylesheets().setAll("/android/resources/splash.css");
        }else if(Platform.isIOS()){
            splash.getStylesheets().setAll("/ios/resources/splash.css");
        }else {
            splash.getStylesheets().setAll("com/shara/styles/splash.css");
        }
    }
    public void connectTask(){
        try {
            loadingText.setText("Connecting");
            HttpResponse<JsonNode> jsonNode = Unirest.get("http://127.0.0.1:8000/test").asJson();
            System.out.println("Status Code: "+jsonNode.getStatus());
            loadingText.setText("Connected");
            splash.hideSplashView();
        } catch (UnirestException ex) {
//            alert();
            loadingText.setText("Could not connect");
        }
    }  
}
