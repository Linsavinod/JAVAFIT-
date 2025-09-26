package com.javafit.fittrack.models;

public class User {
    private int id;
    private String username;
    // In a real app, you would never store a password in plaintext. This is for simplicity.
    private String password; 
    private double heightCm;
    private double weightKg;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public double getHeightCm() { return heightCm; }
    public void setHeightCm(double heightCm) { this.heightCm = heightCm; }
    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
}
