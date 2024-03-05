package com.projectMobileJP.tests;

import com.projectMobileJP.screens.LoginScreen;
import com.projectMobileJP.utils.tests.BaseSignUpTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTest extends BaseSignUpTest {
    @Test
    @Parameters({"email", "password"})
    public void successfulSignUp(String email, String password){
        executeSignUp(email, password);
    }
}
