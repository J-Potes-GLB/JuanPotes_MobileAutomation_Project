package com.projectMobileJP.tests;

import com.projectMobileJP.screens.LoginScreen;
import com.projectMobileJP.utils.tests.BaseSignUpTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseSignUpTest {
    @BeforeMethod
    @Parameters({"email", "password"})
    public void createUserPreviously(String email, String password){
        // Sign up
        executeSignUp(email, password);

        // Clear all input fields
        loginScreen.clearEmailField();
        loginScreen.clearPasswordField();
        loginScreen.clearConfirmationPasswordField();
    }

    @Test
    @Parameters({"email", "password"})
    public void successfulLogin(String email, String password){
        // Click on Login Tab
        loginScreen.clickLoginTabButton();

        // Verify LOGIN button is displayed
        Assert.assertTrue(loginScreen.isLoginButtonDisplayed());

        // Input Email
        loginScreen.sendEmail(email);

        // Input Password
        loginScreen.sendPassword(password);

        // Click on LOGIN button
        loginScreen.clickLoginButton();

        // Verify the login was completed
        Assert.assertTrue(loginScreen.isLoggedInMessageDisplayed());
        Assert.assertEquals(loginScreen.getLoggedInMessageText(), LoginScreen.LOGGED_UP_COMPLETED_TEXT);
        Assert.assertTrue(loginScreen.isOkButtonDisplayed());
    }
}
