package com.javafit.fittrack.models;

import java.util.List;

public class WorkoutSession {
    private int id;
    private String title;
    private String sessionDate;
    private List<Exercise> exercises;

    public WorkoutSession(String title, String sessionDate, List<Exercise> exercises) {
        this.title = title;
        this.sessionDate = sessionDate;
        this.exercises = exercises;
    }

    // Getters
    public String getTitle() { return title; }
    public String getSessionDate() { return sessionDate; }
    public List<Exercise> getExercises() { return exercises; }
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
}
