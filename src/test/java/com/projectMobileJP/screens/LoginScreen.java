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

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"button-LOGIN\")")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign up\"]")
    private WebElement signupTabButton;

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"input-email\")")
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"input-password\")")
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"input-repeat-password\")")
    private WebElement confirmPasswordInput;

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"button-SIGN UP\")")
    private WebElement signupButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"android:id/alertTitle\")")
    private WebElement signedUpMessageTitle;

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

    public boolean isSignUpButtonDisplayed(){
        return isElementDisplayed(this.signupButton);
    }

    public void clickSignUpButton(){
        waitUntilVisibleElement(this.signupButton);
        this.signupButton.click();
    }
}
