/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.Scanner;
/**
*
* @author RC_Student_lab
*/
public class Login {

public static void main(String[] args) {
//Create a scanner instance
Scanner sc = new Scanner(System.in);

//Declarations
String Username;
String Password;
String firstName;
String lastName;
String loginUsername;
String loginPassword;

// Prompt the user to enter their username
System.out.print("Enter your username: ");
Username = sc.next();
// Prompt the user to enter their password
System.out.print("Enter your password: ");
Password = sc.next();
//Prompt the user to their first name
System.out.print("Enter your first name: ");
firstName = sc.next();
//Prompt the user to enter their last name
System.out.print("Enter your last name: ");
lastName = sc.next();

//Check if username meets the condition
if (Username.length() <= 5 && Username.contains("_")) {
System.out.println("Username successfully captured");
}
else{
System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
}
//Check if password meets the condition
if (Password.length() >= 8 && Password.matches(".[A-Z].") && Password.matches(".\\d.") && Password.matches(".[!@#$%^&].*")){
System.out.println("Password successfully captured");
}
else{
System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
}

//Login to the account using same username and password
System.out.print("Enter username: ");
loginUsername = sc.next();
System.out.print("Enter password: ");
loginPassword = sc.next();

// Verify authentication
if (loginUsername.equals(Username) && loginPassword.equals(Password)){
System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
}
else{
System.out.println("Username or password incorrect, please try again");
}















}
}

