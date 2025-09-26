package com.javafit.fittrack.ui;

import com.javafit.fittrack.database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialize the database and create tables if they don't exist
        DatabaseManager.initializeDatabase();

        URL fxmlUrl = getClass().getResource("/com/javafit/fittrack/fxml/login.fxml");
        if (fxmlUrl == null) {
            System.err.println("Cannot find login.fxml");
            return;
        }

        Parent root = FXMLLoader.load(fxmlUrl);
        primaryStage.setTitle("FitTrack - Login");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
