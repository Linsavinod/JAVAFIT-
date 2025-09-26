package com.javafit.fittrack.services;

import com.javafit.fittrack.database.DatabaseManager;
import com.javafit.fittrack.models.User;

public class UserService implements IUserService {
    @Override
    public User validateLogin(String username, String password) {
        return DatabaseManager.findUser(username, password);
    }

    @Override
    public double calculateBmi(double heightCm, double weightKg) {
        if (heightCm <= 0 || weightKg <= 0) {
            return 0;
        }
        double heightInMeters = heightCm / 100.0;
        return weightKg / (heightInMeters * heightInMeters);
    }
}
