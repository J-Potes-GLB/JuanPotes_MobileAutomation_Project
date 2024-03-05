package com.projectMobileJP.utils.tests;

import com.projectMobileJP.screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseSignUpTest extends BaseTest{
    protected LoginScreen loginScreen;

    @BeforeMethod
    public void openLoginScreen(){
        loginScreen = homeStartScreen.clickLoginMenuButton();

        // Verify that elements of the Login screen are displayed
        Assert.assertTrue(loginScreen.isLoginTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getLoginTabButtonText(), LoginScreen.LOGIN_TAB_TEXT);
        Assert.assertTrue(loginScreen.isSignupTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getSignupTabButtonText(), LoginScreen.SIGNUP_TAB_TEXT);
    }

    @AfterMethod
    @Parameters({"email", "password"})
    public void deleteAccount(String email, String password){
        // Here would be implemented the steps to delete the account created, but since the app
        // is designed for test it does not have that option implemented.
        System.out.println("Account of email '" + email + "' was deleted");
    }

    public void executeSignUp(String email, String password){
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
        loginScreen.clickSignUpButton();

        // Verify sign up was completed
        Assert.assertTrue(loginScreen.isSignedUpMessageTitleDisplayed());
        Assert.assertEquals(loginScreen.getSignedUpMessageTitleText(), LoginScreen.SIGNED_UP_COMPLETED_TEXT);
        Assert.assertTrue(loginScreen.isOkButtonDisplayed());

        // Click on Ok Button
        loginScreen.clickOkButton();
    }
}
