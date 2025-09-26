package com.javafit.fittrack.services;

import com.javafit.fittrack.models.WorkoutSession;
import com.javafit.fittrack.models.User;
import java.util.List;

public interface IWorkoutService {
    void saveWorkoutSession(WorkoutSession session, User user);
    List<WorkoutSession> getWorkoutHistoryForUser(User user);
}
