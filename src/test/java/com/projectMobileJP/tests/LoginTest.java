package com.projectMobileJP.tests;

import com.projectMobileJP.utils.tests.BaseSignUpTest;
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

        // Verify LOGIN button is displayed

        // Input Email

        // Input Password

        // Click on LOGIN button

        // Verify the login was completed
    }
}
