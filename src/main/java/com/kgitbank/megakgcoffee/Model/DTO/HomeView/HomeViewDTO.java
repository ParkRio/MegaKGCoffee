package com.kgitbank.megakgcoffee.Model.DTO.HomeView;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import java.net.URL;

public class HomeViewDTO {
    private String login;
    private String home;
    private String setting;
    private String menu;
    private Stage backStage;
    private Path backPath;
    private Parent parent;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    private Scene backScene;
    private Button button;
    private URL url;
    private String testId;


    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }



    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Stage getBackStage() {
        return backStage;
    }

    public void setBackStage(Stage backStage) {
        this.backStage = backStage;
    }

    public Path getBackPath() {
        return backPath;
    }

    public void setBackPath(Path backPath) {
        this.backPath = backPath;
    }

    public Scene getBackScene() {
        return backScene;
    }

    public void setBackScene(Scene backScene) {
        this.backScene = backScene;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
