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
        // USE THE LABEL: Set a welcome message for the logged-in user.
        if (currentUser != null && usernameLabel != null) {
            usernameLabel.setText("Welcome, " + currentUser.getUsername() + "!");
        }
        
        System.out.println("MainController initialized for user: " + currentUser.getUsername());
        // Load home page by default
        loadView("home");
    }

    @FXML
    private void handleNavHome(ActionEvent event) {
        loadView("home");
    }
    @FXML
    private void handleNavHistory(ActionEvent event) {
        loadView("history");
    }
    @FXML
    private void handleNavProfile(ActionEvent event) {
        loadView("profile");
    }
    @FXML
    private void handleLogSession(ActionEvent event) {
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
            e.printStackTrace();
        }
    }
    
    private void loadView(String viewName) {
        try {
            // Load the FXML file for the selected view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javafit/fittrack/fxml/" + viewName + ".fxml"));
            Node view = loader.load();

            // If the loaded controller needs the user object, you can pass it here
            // Example:
            // if (loader.getController() instanceof ProfileController) {
            //     ((ProfileController) loader.getController()).setCurrentUser(currentUser);
            // }

            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error: show a message to the user
            mainPane.setCenter(new Label("Error: Could not load view."));
        }
    }
}

