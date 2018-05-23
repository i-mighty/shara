/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.views;

import com.shara.Shara;
import java.io.InputStream;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author mighty
 */
public class FontManager {
    public static final String ROOT = "com/shara/fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf",
            MADISON = ROOT + "madison.ttf",
            LEMONADA = ROOT + "Lemonada.ttf",
            MADISONSHADOWED = ROOT+ "madisonshadowed.ttf";
    public static Font getFont(String name, Integer size){
        InputStream font = Shara.class.getResourceAsStream(name);
        return Font.loadFont(font, size);
    }
    public static void markAsIconContainer(Node n, Font f){
        if(n instanceof Pane){
            ((Pane) n).getChildren().forEach((child) ->{
                markAsIconContainer(child, f);
            });
        }else if (n instanceof Label) {
            ((Label) n).setFont(f);
        }else if (n instanceof TextField) {
            ((TextField) n).setFont(f);
        }else if (n instanceof Button) {
            ((Button) n).setFont(f);
        }
    }
}