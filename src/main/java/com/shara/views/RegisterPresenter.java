/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.views;

import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.HOME_VIEW;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SHOW_IN_DRAWER;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SKIP_VIEW_STACK;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.FadeInLeftBigTransition;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.shara.Shara;
import static com.shara.controllers.auth.UserAuth.register;
import com.shara.models.User;
import static com.shara.views.AppViewManager.view;
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
public class RegisterPresenter extends GluonPresenter<Shara>{
    @FXML private View register;
    @FXML private VBox form;
    AppBar appBar = getApp().getAppBar();
    public void initialize(){
        register.setShowTransitionFactory(FadeInLeftBigTransition::new);
        register.showingProperty().addListener((obs, oldValue, newValue) ->{
            if(newValue){
                appBar.setVisible(false);
                System.out.println("DDDDDDDDDddd");
            }
        });
    }
    @FXML
    void authExternal(ActionEvent event) {
        getApp().switchView("EXTERNAL_AUTH_VIEW");
    }
    @FXML
    void showLogin(ActionEvent event) {
        getApp().switchView("LOGIN_VIEW");
    }
    @FXML void registerAction(ActionEvent event){
        //register, save api token and redirect
        HashMap<String, Object> formData = new HashMap<>();
        ObservableList<Node> children = form.getChildren();
        children.forEach((child)->{
            if(child instanceof TextField){
                formData.put(child.getId(), ((TextField) child).getText());
            }
            if(child instanceof PasswordField){
                formData.put(child.getId(), ((PasswordField) child).getText());
            }
        });
        System.out.println(formData);
//        System.out.println(register(formData).getObject().toString());
    }
}
