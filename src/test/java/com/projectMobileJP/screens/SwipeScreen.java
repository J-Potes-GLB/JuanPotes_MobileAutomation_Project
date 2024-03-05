package com.projectMobileJP.screens;

import com.google.common.collect.ImmutableMap;
import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class SwipeScreen extends BaseScreen {
    public static final String SWIPE_TITLE_TEXT = "Swipe horizontal";
    public static final String SWIPE_SUBTITLE_TEXT = "Or swipe vertical to find what I'm hiding.";
    public static final String TITLE_CARD_1_TEXT = "FULLY OPEN SOURCE";
    public static final String TITLE_CARD_2_TEXT = "GREAT COMMUNITY";
    public static final String TITLE_CARD_3_TEXT = "JS.FOUNDATION";
    public static final String TITLE_CARD_4_TEXT = "SUPPORT VIDEOS";
    public static final String TITLE_CARD_5_TEXT = "EXTENDABLE";
    public static final String TITLE_CARD_6_TEXT = "COMPATIBLE";
    public static final String YOU_FOUND_ME_TEXT = "You found me!!!";

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

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"SUPPORT VIDEOS\")")
    private WebElement titleCard4;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"EXTENDABLE\")")
    private WebElement titleCard5;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"COMPATIBLE\")")
    private WebElement titleCard6;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"You found me!!!\")")
    private WebElement youFoundMeMessage;

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

    public void swipeCardRight(){
        // Swipe code taken from Appium documentation
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) cardsCarrousel).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public void swipeDown(){
        // Swipe code taken from Appium documentation
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "up",
                "percent", 1.0
        ));
    }

    public boolean isTitleCardDisplayed(int cardNum){
        WebElement element = getTitleCardElement(cardNum);
        try {
            return isElementDisplayed(element, false);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTitleCardText(int cardNum){
        WebElement element = getTitleCardElement(cardNum);
        if(element != null){
            return element.getText();
        }
        else {
            return null;
        }
    }

    private WebElement getTitleCardElement(int cardNum){
        switch (cardNum){
            case 1:
                return this.titleCard1;
            case 2:
                return this.titleCard2;
            case 3:
                return this.titleCard3;
            case 4:
                return this.titleCard4;
            case 5:
                return this.titleCard5;
            case 6:
                return this.titleCard6;
            default:
                return null;
        }
    }

    public boolean isYouFoundMeMessageDisplayed(){
        try {
            return isElementDisplayed(this.youFoundMeMessage, false);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getYouFindMeMessageText(){
        return this.youFoundMeMessage.getText();
    }
}
