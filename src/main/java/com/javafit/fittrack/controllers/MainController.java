package com.javafit.fittrack.controllers;

import java.io.IOException;

import com.javafit.fittrack.models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private BorderPane mainPane;
    @FXML
    private Label usernameLabel;

    private User currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = user;
        if (currentUser != null && usernameLabel != null) {
            usernameLabel.setText("Welcome, " + currentUser.getUsername() + "!");
        }
        System.out.println("MainController initialized for user: " + currentUser.getUsername());
        loadView("home");
    }

    @FXML
    private void handleNavHome() {
        loadView("home");
    }

    @FXML
    private void handleNavHistory() {
        loadView("history");
    }

    @FXML
    private void handleNavProfile() {
        loadView("profile");
    }

    @FXML
    private void handleLogSession() {
        loadView("log_session");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/javafit/fittrack/fxml/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 400, 500));
            stage.setTitle("FitTrack - Login");
            stage.setResizable(false);
        } catch (IOException e) {
            // It's better to log this error to a file in a real application
            e.printStackTrace();
        }
    }

    private void loadView(String viewName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javafit/fittrack/fxml/" + viewName + ".fxml"));
            Node view = loader.load();

            if (loader.getController() instanceof HomeController) {
                ((HomeController) loader.getController()).initialize(currentUser);
            }

            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
            mainPane.setCenter(new Label("Error: Could not load " + viewName + " view."));
        }
    }
}