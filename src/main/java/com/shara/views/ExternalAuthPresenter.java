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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.glyphfont.FontAwesome;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;



/**
 *
 * @author mighty
 */
public class ExternalAuthPresenter extends GluonPresenter<Shara>{
    @FXML private View external;
    @FXML private Label fb;
    AppBar appBar = getApp().getAppBar();
    public void initialize(){
        external.setShowTransitionFactory(FadeInRightBigTransition::new);
        external.showingProperty().addListener((obs, oldValue, newValue) ->{
            if(newValue){
                appBar.setVisible(false);
            }
        });
    }
}
