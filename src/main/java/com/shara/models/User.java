/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shara.models;

import java.time.LocalDateTime;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author mighty
 */
public class User {
    //Default constructor
//    public void User(Integer id, String fn, String ln, String em, String st, String cy, String bio, String av, String bn, Boolean auth, Boolean out){
//        this.id.set(id);
//        this.first_name.set(fn);
//        this.last_name.set(ln);
//        this.email.set(em);
//        this.state.set(st);
//        this.city.set(cy);
//        this.bio.set(bio);
//        this.avatar.set(av);
//        this.auth.set(auth);
//        this.loggedOut.set(out);
//    }
    //Object fields
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty state = new SimpleStringProperty();
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty bio = new SimpleStringProperty();
    private final StringProperty avatar = new SimpleStringProperty();
    private final StringProperty apiToken = new SimpleStringProperty();
    private final StringProperty banner = new SimpleStringProperty();
    private final ObjectProperty createdAt = new SimpleObjectProperty();
    private final ObjectProperty updatedAt = new SimpleObjectProperty();
    public  final BooleanProperty auth = new SimpleBooleanProperty();
    public final BooleanProperty loggedOut = new SimpleBooleanProperty();
    
    //Accessors
    
    //First name access functions
    public final Integer getId(){return id.get();}
    public void setId(Integer id) {this.id.set(id);}
    public final IntegerProperty idProperty() {return this.id;}
    //First name access functions
    public final String getFirstName(){return firstName.get();}
    public void setFirstName(String firstName) {this.firstName.set(firstName);}
    public final StringProperty firstNameProperty() {return this.firstName;}
    //Last name access functions
    public final String getLastName(){return lastName.get();}
    public void setLastName(String lastName) {this.lastName.set(lastName);}
    public final StringProperty lastNameProperty() {return this.lastName;}
    //Email access functions
    public final String getEmail(){return email.get();}
    public void setEmail(String email) {this.email.set(email);}
    public final StringProperty emailProperty() {return this.email;}
    //State access functions
    public final String getState(){return state.get();}
    public void setState(String state) {this.state.set(state);}
    public final StringProperty stateProperty() {return this.state;}
    //City access functions
    public final String getCity(){return city.get();}
    public void setCity(String city) {this.city.set(city);}
    public final StringProperty cityProperty() {return this.city;}
    //Bio access functions
    public final String getBio(){return bio.get();}
    public void setBio(String bio) {this.bio.set(bio);}
    public final StringProperty bioProperty() {return this.bio;}
    //Avatar Link access functions
    public final String getAvatar(){return avatar.get();}
    public void setAvatar(String avatar) {this.avatar.set(avatar);}
    public final StringProperty avatarProperty() {return this.avatar;}
    //Banner Link access functions
    public final String getBanner(){return banner.get();}
    public void setBanner(String banner) {this.banner.set(banner);}
    public final StringProperty bannerProperty() {return this.banner;}
    //Banner Link access functions
    public final Object getCreatedAt(){return createdAt.get();}
    public void setCreatedAt(String createdAt) {this.createdAt.set(LocalDateTime.parse(createdAt));}
    public final ObjectProperty createdAtProperty() {return this.createdAt;}
    //Banner Link access functions
    public final Object getUpdatedAt(){return updatedAt.get();}
    public void setUpdatedAt(String updatedAt) {this.updatedAt.set(LocalDateTime.parse(updatedAt));}
    public final ObjectProperty updatedAtProperty() {return this.updatedAt;}
    //Api Token Link access functions
    public final String getApiToken(){return apiToken.get();}
    public void setApiToken(String apiToken) {this.apiToken.set(apiToken);}
    public final StringProperty apiTokenProperty() {return this.apiToken;}
    //Auth Link access functions
    public final Boolean getAuth(){return auth.get();}
    public void setAuth(Boolean auth) {this.auth.set(auth);}
    public final BooleanProperty authProperty() {return this.auth;}
    //LoggedOut Link access functions
    public final Boolean getLoggedOut(){return loggedOut.get();}
    public void setLoggedOut(Boolean loggedOut) {this.loggedOut.set(loggedOut);}
    public final BooleanProperty loggedOutProperty() {return this.loggedOut;}
}
