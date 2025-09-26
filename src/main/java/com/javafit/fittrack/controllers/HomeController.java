package com.javafit.fittrack.controllers;

import com.javafit.fittrack.models.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML
    private Label welcomeLabel;

    public void initialize(User user) {
        welcomeLabel.setText("Good Morning, " + user.getUsername() + "!");
    }
}