package com.shara.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.shara.Shara;
import javafx.fxml.FXML;

public class MainPresenter extends GluonPresenter<Shara> {

    @FXML
    private View main;
    private FloatingActionButton fab;
    public void initialize() {
        main.setShowTransitionFactory(BounceInRightTransition::new);
        fab = new FloatingActionButton();
        fab.show();
        main.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = getApp().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
                appBar.setTitleText("Main");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });
        getApp().getDrawer().getHeader().setStyle("-fx-background-image: url('../images/menu_header,jpg');");
    }
}
