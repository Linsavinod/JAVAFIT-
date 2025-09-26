package com.javafit.fittrack.services;

import com.javafit.fittrack.models.User;

public interface IUserService {
    User validateLogin(String username, String password);
    double calculateBmi(double heightCm, double weightKg);
}
