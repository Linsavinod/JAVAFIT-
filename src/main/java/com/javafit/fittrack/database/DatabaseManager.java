package com.javafit.fittrack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javafit.fittrack.models.User;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:fittrack.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " username text NOT NULL UNIQUE,\n"
                    + " password text NOT NULL,\n"
                    + " height_cm real,\n"
                    + " weight_kg real\n"
                    + ");";
            stmt.execute(sql);

            // Check if the default user exists
            try (PreparedStatement checkUserStmt = conn.prepareStatement("SELECT id FROM users WHERE username = ?")) {
                checkUserStmt.setString(1, "javafit");
                ResultSet rs = checkUserStmt.executeQuery();
                if (!rs.next()) {
                    // Insert a default user if one doesn't exist
                    String insertSql = "INSERT INTO users(username, password, height_cm, weight_kg) VALUES(?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                        pstmt.setString(1, "javafit");
                        pstmt.setString(2, "password123"); // In a real app, use hashed passwords
                        pstmt.setDouble(3, 175.0);
                        pstmt.setDouble(4, 70.0);
                        pstmt.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static User findUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"));
                user.setHeightCm(rs.getDouble("height_cm"));
                user.setWeightKg(rs.getDouble("weight_kg"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
