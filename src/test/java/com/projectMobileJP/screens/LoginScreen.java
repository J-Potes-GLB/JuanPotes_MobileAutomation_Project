package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    public static final String LOGIN_TAB_TEXT = "Login";
    public static final String SIGNUP_TAB_TEXT = "Sign up";
    public static final String SIGNED_UP_COMPLETED_TEXT = "Signed Up!";
    public static final String LOGGED_UP_COMPLETED_TEXT = "You are logged in!";

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

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"android:id/button1\")")
    private WebElement okButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"You are logged in!\")")
    private WebElement loggedInMessage;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginTabButtonDisplayed(){
        return isElementDisplayed(this.loginTabButton);
    }

    public String getLoginTabButtonText(){
        return this.loginTabButton.getText();
    }

    public void clickLoginTabButton(){
        waitUntilVisibleElement(this.loginTabButton);
        this.loginTabButton.click();
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

    public void sendEmail(String email){
        sendStringInputToElement(this.emailInput, email);
    }

    public void clearEmailField(){
        this.emailInput.clear();
    }

    public void sendPassword(String password){
        sendStringInputToElement(this.passwordInput, password);
    }

    public void clearPasswordField(){
        this.passwordInput.clear();
    }

    public void sendConfirmationPassword(String password){
        sendStringInputToElement(this.confirmPasswordInput, password);
    }

    public void clearConfirmationPasswordField(){
        this.confirmPasswordInput.clear();
    }

    public boolean isSignedUpMessageTitleDisplayed(){
        return isElementDisplayed(this.signedUpMessageTitle);
    }

    public String getSignedUpMessageTitleText(){
        return this.signedUpMessageTitle.getText();
    }

    public boolean isOkButtonDisplayed(){
        return isElementDisplayed(this.okButton);
    }

    public void clickOkButton(){
        waitUntilVisibleElement(this.okButton);
        this.okButton.click();
    }

    public boolean isLoginButtonDisplayed(){
        return isElementDisplayed(this.loginButton);
    }

    public void clickLoginButton(){
        waitUntilVisibleElement(this.loginButton);
        this.loginButton.click();
    }

    public boolean isLoggedInMessageDisplayed(){
        return isElementDisplayed(this.loggedInMessage);
    }

    public String getLoggedInMessageText(){
        return this.loggedInMessage.getText();
    }
}
