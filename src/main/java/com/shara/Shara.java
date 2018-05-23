package com.shara;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.SettingsService;
import com.gluonhq.charm.down.plugins.SettingsServiceFactory;
import com.shara.views.AppViewManager;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.charm.glisten.visual.Theme;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.shara.models.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Shara extends MobileApplication {
    public static User user = new User();
    public static String CSRF_TOKEN;
    public static final String APP_NAME = "Shara";
    public boolean firstRun = true;
    @Override
    public void init() {
        try {
            HttpResponse<JsonNode> node = Unirest.get("http://127.0.0.1:8000/ping").asJson();
            CSRF_TOKEN = node.getBody().getObject().getString("csrf_token");
        } catch (UnirestException ex) {
            Logger.getLogger(Shara.class.getName()).log(Level.SEVERE, null, ex);
        }
        Services.registerServiceFactory(new SettingsServiceFactory());
        Services.get(SettingsService.class).ifPresent(settings ->{
            if(settings.retrieve(".auth") == null){
                settings.store(".auth", "false");
            }
        });
        AppViewManager.registerViewsAndDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {   
        setObjectMapper();
        Swatch.BLUE_GREY.assignTo(scene);
        scene.getStylesheets().add(Shara.class.getResource("style.css").toExternalForm());
        Stage stage = (Stage) scene.getWindow();
        stage.getIcons().add(new Image(Shara.class.getResourceAsStream("/com/shara/images/icon.png")));
        if(Platform.isDesktop()){
            stage.setTitle(APP_NAME);
        }
    }
    public static void setObjectMapper(){
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                        = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
//                    jacksonObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
//                    jacksonObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
