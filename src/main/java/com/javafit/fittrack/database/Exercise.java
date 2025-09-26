package com.javafit.fittrack.models;

public class Exercise {
    private String name;
    private int sets;
    private int reps;

    public Exercise(String name, int sets, int reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }

    // Getters
    public String getName() { return name; }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
}
