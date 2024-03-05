package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    public static final String LOGIN_TAB_TEXT = "Login";
    public static final String SIGNUP_TAB_TEXT = "Sign up";

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Login\"])[1]")
    private WebElement loginTabButton;

    private WebElement loginEmailInput;

    private WebElement loginPasswordInput;

    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign up\"]")
    private WebElement signupTabButton;

    private WebElement signupEmailInput;

    private WebElement signupPasswordInput;

    private WebElement signupConfirmPasswordInput;

    private WebElement signupButton;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginTabButtonDisplayed(){
        return isElementDisplayed(this.loginTabButton);
    }

    public String getLoginTabButtonText(){
        return this.loginTabButton.getText();
    }

    public boolean isSignupTabButtonDisplayed(){
        return isElementDisplayed(this.signupTabButton);
    }

    public String getSignupTabButtonText(){
        return this.signupTabButton.getText();
    }

    public void clickSignupTabButton(){
        waitUntilVisibleElement(this.signupTabButton);
        this.signupTabButton.click();
    }
}
