package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeStartScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"WEBDRIVER\")")
    private WebElement webDriverTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().className(\"android.widget.ImageView\")")
    private List<WebElement> homeImages;

    public HomeStartScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(){
        return isWebElementDisplayed(this.webDriverTitle);
    }
}
