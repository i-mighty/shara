package com.shara.views;

import com.gluonhq.charm.glisten.afterburner.AppView;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.HOME_VIEW;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SHOW_IN_DRAWER;
import static com.gluonhq.charm.glisten.afterburner.AppView.Flag.SKIP_VIEW_STACK;
import com.gluonhq.charm.glisten.afterburner.AppViewRegistry;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.afterburner.Utils;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.SettingsService;
import com.gluonhq.charm.down.plugins.SettingsServiceFactory;
import javafx.scene.image.Image;
import java.util.Locale;
import org.controlsfx.glyphfont.FontAwesome;
public class AppViewManager {

    public static final AppViewRegistry REGISTRY = new AppViewRegistry();
    
    public static  AppView START_VIEW = view("Start", StartPresenter.class, MaterialDesignIcon.HOME, SHOW_IN_DRAWER);
    public static final AppView SPLASH_VIEW = view("Splash", SplashPresenter.class, MaterialDesignIcon.PAGES);
    public static final AppView REGISTER_VIEW  = view("Register", RegisterPresenter.class, MaterialDesignIcon.PERSON_ADD);
    public static  AppView LOGIN_VIEW  = view("Login", LoginPresenter.class, MaterialDesignIcon.PERSON_ADD);
    public static final AppView MAIN_VIEW = view("Main", MainPresenter.class, MaterialDesignIcon.DASHBOARD, SHOW_IN_DRAWER);
    public static final AppView EXTERNAL_AUTH_VIEW = view("Services",  ExternalAuthPresenter.class, MaterialDesignIcon.ADD);
    
    public static AppView view(String title, Class<? extends GluonPresenter<?>> presenterClass, MaterialDesignIcon menuIcon, AppView.Flag... flags ) {
        return REGISTRY.createView(name(presenterClass), title, presenterClass, menuIcon, flags);
    }

    private static String name(Class<? extends GluonPresenter<?>> presenterClass) {
        return presenterClass.getSimpleName().toUpperCase(Locale.ROOT).replace("PRESENTER", "");
    }
    
    public static void registerViewsAndDrawer(MobileApplication app) {
        Services.registerServiceFactory(new SettingsServiceFactory());
        Services.get(SettingsService.class).ifPresent((SettingsService settings) -> {
            if(settings.retrieve(".auth") == null){
                settings.store(".auth", "false");
            }
            if (settings.retrieve(".auth").equals("false")) {
                LOGIN_VIEW = view("Login", LoginPresenter.class, MaterialDesignIcon.PERSON_ADD, SKIP_VIEW_STACK, HOME_VIEW);
            }
        });
        REGISTRY.getViews().forEach((view) -> {
            
            if(view.getId() != "SPLASH_VIEW"){
                view.registerView(app);
                System.out.println(view.getId());
            }
        });
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Mobile",
                "Multi View Project",
        new Avatar(21, new Image(AppViewManager.class.getResourceAsStream("/com/shara/images/icon.png"))));
        header.setStyle("-fx-background-color: #33fd26");
        Utils.buildDrawer(app.getDrawer(), header, REGISTRY.getViews());
        
    }
    private static void setNavHeader(){
    
    }
}
