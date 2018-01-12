package com.company.utils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryWindowsInit implements WindowsInit{

    private PrimaryWindowsInit(String path) {
        WindowsInitializer(path);
    }

    @Override
    public void WindowsInitializer(String path) {
        try {
            Stage appWindow = new Stage();
            Pane appWindowRoot = FXMLLoader.load(getClass().getResource(path));

            Scene scene = new Scene(appWindowRoot);
            appWindow.setScene(scene);
            appWindow.setResizable(false);
            appWindow.setTitle("Starfox");
            appWindow.setOnCloseRequest(e -> Platform.exit());
            appWindow.show();

        } catch (IOException error) {
            System.exit(1);
        }
    }

    public static void signUpWindow() {
        new PrimaryWindowsInit("/resources/fxml/signup.fxml");
    }

    public static void appWindow() {
        new PrimaryWindowsInit("/resources/fxml/mainscreen.fxml");
    }

    public static void loginWindow() {
        new PrimaryWindowsInit("/resources/fxml/login.fxml");
    }

    public static void successWindow() {
        new PrimaryWindowsInit("/resources/fxml/success.fxml");
    }
}
