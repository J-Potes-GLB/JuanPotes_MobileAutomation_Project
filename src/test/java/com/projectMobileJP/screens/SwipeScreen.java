package com.projectMobileJP.screens;

import com.google.common.collect.ImmutableMap;
import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class SwipeScreen extends BaseScreen {
    public static final String SWIPE_TITLE_TEXT = "Swipe horizontal";
    public static final String SWIPE_SUBTITLE_TEXT = "Or swipe vertical to find what I'm hiding.";

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Swipe horizontal\")")
    private WebElement swipeHorizontalTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")")
    private WebElement swipeVerticalSubtitle;

    // Here I used xpath only as practice, otherwise I would have used the description instead
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement cardsCarrousel;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement titleCard1;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"GREAT COMMUNITY\")")
    private WebElement titleCard2;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"JS.FOUNDATION\")")
    private WebElement titleCard3;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSwipeHorizontalTitleDisplayed(){
        return isElementDisplayed(this.swipeHorizontalTitle, true);
    }

    public String getSwipeSwipeHorizontalTitleText(){
        return this.swipeHorizontalTitle.getText();
    }

    public boolean isSwipeVerticalSubtitleDisplayed(){
        return isElementDisplayed(this.swipeVerticalSubtitle, true);
    }

    public String getSwipeVerticalSubtitleText(){
        return this.swipeVerticalSubtitle.getText();
    }

    public void swipeCardLeft(){
        // Swipe code taken from Appium documentation
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) cardsCarrousel).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public void swipeCardRight(){
        // Swipe code taken from Appium documentation
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) cardsCarrousel).getId(),
                "direction", "right",
                "percent", 0.75
        ));
    }
}
