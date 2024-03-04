package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {
    public static final String SWIPE_TITLE_TEXT = "Swipe horizontal";
    public static final String SWIPE_SUBTITLE_TEXT = "Or swipe vertical to find what I'm hiding.";

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Swipe horizontal\")")
    private WebElement swipeHorizontalTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")")
    private WebElement swipeVerticalSubtitle;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSwipeHorizontalTitleDisplayed(){
        waitUntilVisibleElement(this.swipeHorizontalTitle);
        return this.swipeHorizontalTitle.isDisplayed();
    }

    public String getSwipeSwipeHorizontalTitleText(){
        return this.swipeHorizontalTitle.getText();
    }

    public boolean isSwipeVerticalSubtitleDisplayed(){
        waitUntilVisibleElement(this.swipeVerticalSubtitle);
        return this.swipeVerticalSubtitle.isDisplayed();
    }

    public String getSwipeVerticalSubtitleText(){
        return this.swipeVerticalSubtitle.getText();
    }
}
