package com.projectMobileJP.tests;

import com.projectMobileJP.screens.LoginScreen;
import com.projectMobileJP.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private LoginScreen loginScreen;

    @BeforeMethod
    public void openLoginScreen(){
        loginScreen = homeStartScreen.clickLoginMenuButton();

        // Verify that elements of the Login screen are displayed
        Assert.assertTrue(loginScreen.isLoginTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getLoginTabButtonText(), LoginScreen.LOGIN_TAB_TEXT);
        Assert.assertTrue(loginScreen.isSignupTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getSignupTabButtonText(), LoginScreen.SIGNUP_TAB_TEXT);
    }

    @Test
    @Parameters({"email", "password"})
    public void successfulSignUp(String email, String password){
        // Click on Sign Up Tab Button
        loginScreen.clickSignupTabButton();

        // Verify SIGN UP button is displayed
        Assert.assertTrue(loginScreen.isSignUpButtonDisplayed());

        // Input Email
        loginScreen.sendEmail(email);

        // Input Password
        loginScreen.sendPassword(password);

        // Input Confirm Password
        loginScreen.sendConfirmationPassword(password);

        // Click on SIGN UP button
    }
}
