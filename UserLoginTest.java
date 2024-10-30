/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
*
* @author RC_Student_lab
*/
public class UserLoginTest {



/**
* Test of checkUserName method, of class UserLogin.
*/
//test valid username
@org.junit.jupiter.api.Test
public void testCheckUserNameCorrectFormat() {
System.out.println("checkUserNameCorrectFormat");
String username = "kyl_1";
UserLogin instance = new UserLogin();
String expResult = "Welcome <user first name>, <user last name> it is great to see you.";
    boolean result = instance.checkUserName(username);
assertEquals(expResult, result);

}
//test invalid username
@org.junit.jupiter.api.Test
public void testCheckUserNameIncorrectFormat() {
System.out.println("checkUserNameIncorrectFormat");
String username = "kyle!!!!!!!";
UserLogin instance = new UserLogin();
String expResult = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
    boolean result = instance.checkUserName(username);
assertEquals(expResult, result);
}

/**
* Test of checkPasswordComplexity method, of class UserLogin.
*/
//test valid password
@org.junit.jupiter.api.Test
public void testCheckPasswordComplexityValid() {
System.out.println("checkPasswordComplexity");
String password = "Ch&&sec@ke99!";
UserLogin instance = new UserLogin();
String expResult = "Password successfully captured";
    boolean result = instance.checkPasswordComplexity(password);
assertEquals(expResult, result);

}
// test invalid password
@org.junit.jupiter.api.Test
public void testCheckPasswordComplexityInvalid() {
System.out.println("checkPasswordComplexity");
String password = "password";
UserLogin instance = new UserLogin();
String expResult = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
    boolean result = instance.checkPasswordComplexity(password);
assertEquals(expResult, result);
}

/**
* Test of registerUser method, of class UserLogin.
*/
//test valid login
@org.junit.jupiter.api.Test
public void testLoginUserSuccess() {
System.out.println("loginUserSuccess");
String loginUsername = "kyl_1";
String loginPassword = "Ch&&sec@ke99!";
UserLogin instance = new UserLogin();
boolean expResult = true;
boolean result = instance.loginUser(loginUsername, loginPassword);
assertEquals(expResult, result);

}
//test invalid login
@org.junit.jupiter.api.Test
public void testLoginUserFailed() {
System.out.println("loginUserFailure");
String loginUsername = "kyle!!!!!!!";
String loginPassword = "password";
UserLogin instance = new UserLogin();
boolean expResult = false;
boolean result = instance.loginUser(loginUsername, loginPassword);
assertEquals(expResult, result);
}

/**
* Test of loginUser method, of class UserLogin. change
*/
//test valid username cottectly formatted
@org.junit.jupiter.api.Test
public void testUsernameFormatCorrect() {
System.out.println("usernameFormatCorrect");
String username = "kyl_1";
UserLogin instance = new UserLogin();
boolean result = instance.isUsernameFormattedCorrectly(username);
assertTrue(result);


}
//test invalid username cottectly formatted
@org.junit.jupiter.api.Test
public void testUsernameFormatIncorrect() {
System.out.println("usernameFormatIncorrect");
String username = "kyle!!!!!!!";
UserLogin instance = new UserLogin();
boolean result = instance.isUsernameFormattedCorrectly(username);
assertFalse(result);
}


/**
* Test of returnLoginStatus method, of class UserLogin.
*/
//test valid password meet complexity requirements
@org.junit.jupiter.api.Test
public void testPasswordMeetsComplexity() {
System.out.println("passwordMeetsComplexity");
String password = "Ch&&sec@ke99!";
UserLogin instance = new UserLogin();
boolean result = instance.doesPasswordMeetComplexity(password);
assertTrue(result);


}
//test invalid password meet complexity requirements
@org.junit.jupiter.api.Test
public void testPasswordDoesNotMeetComplexity() {
System.out.println("passwordDoesNotMeetComplexity");
String password = "password";
UserLogin instance = new UserLogin();
boolean result = instance.doesPasswordMeetComplexity(password);
assertFalse(result);
}

}
