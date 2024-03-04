package com.projectMobileJP.utils.screens;

import com.projectMobileJP.screens.FormsScreen;
import com.projectMobileJP.screens.LoginScreen;
import com.projectMobileJP.screens.SwipeScreen;
import com.projectMobileJP.screens.WebviewScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.view.View\").description(\"Webview\")")
    protected WebElement webviewMenuButton;

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.view.View\").description(\"Login\")")
    protected WebElement loginMenuButton;

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.view.View\").description(\"Forms\")")
    protected WebElement formsMenuButton;

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.view.View\").description(\"Swipe\")")
    protected WebElement swipeMenuButton;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Wait for an element to be visible
    public void waitUntilVisibleElement(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitSeconds(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    // Click on Bottom Menu Elements
    public WebviewScreen clickWebviewMenuButton() {
        waitUntilVisibleElement(webviewMenuButton);
        webviewMenuButton.click();
        return new WebviewScreen(driver);
    }

    public LoginScreen clickLoginMenuButton(){
        waitUntilVisibleElement(loginMenuButton);
        loginMenuButton.click();
        return new LoginScreen(driver);
    }

    public FormsScreen clickFormsMenuButton() {
        waitUntilVisibleElement(formsMenuButton);
        formsMenuButton.click();
        return new FormsScreen(driver);
    }

    public SwipeScreen clickSwipeMenuButton() {
        waitUntilVisibleElement(swipeMenuButton);
        swipeMenuButton.click();
        return new SwipeScreen(driver);
    }
}
