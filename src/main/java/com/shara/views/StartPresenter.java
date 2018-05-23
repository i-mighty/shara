package com.shara.views;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LifecycleService;
import com.gluonhq.charm.down.plugins.Position;
import com.gluonhq.charm.down.plugins.PositionService;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.FadeInTransition;
import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.shara.Shara;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StartPresenter extends GluonPresenter<Shara> {

    @FXML private View start;
    @FXML private Label label;
    @FXML private ResourceBundle resources;
//    @FXML private GoogleMapView map;
    AppBar appBar = getApp().getAppBar();
    
    public void initialize() {
        start.setShowTransitionFactory(FadeInTransition::new);
        start.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                appBar.setVisible(false);
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
                appBar.setTitleText("Start");
                appBar.getActionItems().add(
                        MaterialDesignIcon.DRIVE_ETA.button(e -> { System.out.println("LALALALA"); }));
            }
        });
        Services.get(PositionService.class).ifPresent(service -> {
            Position position = service.getPosition();
        });
    }
    
    protected void updateAppBar(AppBar appBar){
        appBar.setVisible(false);
    }
    
    @FXML void showMenu(ActionEvent event) {
        getApp().getDrawer().open();
    }
public void alert(){
        Alert alert =  new Alert(javafx.scene.control.Alert.AlertType.WARNING, "Please check your internet connection and try again");
                alert.setTitleText("Could not connect to the Internet");
                alert.showAndWait();     
                alert.setOnCloseRequest( g ->{
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                });
    }    
}
