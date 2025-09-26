package com.javafit.fittrack.services;

import com.javafit.fittrack.models.WorkoutSession;
import com.javafit.fittrack.models.User;

import java.util.ArrayList;
import java.util.List;

// This is a mock service. A real implementation would talk to the DatabaseManager.
public class WorkoutService implements IWorkoutService {
    private final List<WorkoutSession> sessions = new ArrayList<>();

    @Override
    public void saveWorkoutSession(WorkoutSession session, User user) {
        // In a real app, this would save to the database.
        sessions.add(0, session);
        System.out.println("Session saved for user " + user.getUsername());
    }

    @Override
    public List<WorkoutSession> getWorkoutHistoryForUser(User user) {
        // In a real app, this would fetch from the database.
        return new ArrayList<>(sessions);
    }
}
