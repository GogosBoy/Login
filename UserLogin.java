/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 * @author RC_Student_lab
 */
public class UserLogin {

    // Attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Method to check username
    public boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 
                && password.matches(".*[A-Z].*") 
                && password.matches(".*\\d.*") 
                && password.matches(".*[!@#$%^&*()].*");
    }

    // Constructor
    public String registerUser(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }

        return "Username and Password successfully captured. User registered!";
    }

    // Method for account login using the same username and password
    public boolean loginUser(String loginUsername, String loginPassword) {
        return loginUsername.equals(username) && loginPassword.equals(password);
    }

    // Method for successful and failed login
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
