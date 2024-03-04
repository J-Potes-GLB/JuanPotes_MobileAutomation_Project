package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {
    public static final String GET_STARTED_TEXT = "Get Started";
    public static final String SEARCH_BUTTON_TEXT = "Search";

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.widget.TextView\").textContains(\"Get Started\")")
    private WebElement getStartedButton;

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Search\")")
    private WebElement searchButton;

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isGetStartedButtonDisplayed(){
        return this.getStartedButton.isDisplayed();
    }

    public String getGetStartedButtonText(){
        return this.getStartedButton.getText();
    }

    public boolean isSearchButtonDisplayed(){
        return this.searchButton.isDisplayed();
    }

    public String getSearchButtonText(){
        return this.searchButton.getText();
    }
}
