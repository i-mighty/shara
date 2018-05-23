/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.FadeInRightBigTransition;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.shara.Shara;
import static com.shara.controllers.auth.UserAuth.login;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author mighty
 */
public class LoginPresenter extends GluonPresenter<Shara>{
    @FXML private View login;
    @FXML private VBox form;
    @FXML private TextField email;
    @FXML private PasswordField password;
    AppBar appBar = getApp().getAppBar();
    public void initialize(){
        login.setShowTransitionFactory(FadeInRightBigTransition::new);
        login.showingProperty().addListener((obs, oldValue, newValue) -> {
            if(newValue){
                appBar.setVisible(false);
            }
        });
    }
    @FXML
    void showRegister(ActionEvent event) {
        getApp().switchView("REGISTER_VIEW");
    }
    @FXML void loginAction(ActionEvent event){
        //Login, Store api token and redirect
        HashMap<String, Object> formData = new HashMap<>();
        ObservableList<Node> children = form.getChildren();
//        children.forEach((child)->{
//            if(child instanceof TextField){
//                formData.put(child.getId(), ((TextField) child).getText());
//            }
//            if(child instanceof PasswordField){
//                formData.put(child.getId(), ((PasswordField) child).getText());
//            }
//        });
//    formData.put("email", "carmella92@example.com");
//    formData.put("password", "secret");
        System.out.println(formData);
        getApp().switchView("MAIN_VIEW");
//        System.out.println(login(formData));
    } 
}
