package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    public static final String DRAG_AND_DROP_TITLE_TEXT = "Drag and Drop";

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Drag and Drop\")")
    private WebElement dragAndDropTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().description(\"renew\")")
    private WebElement renewButton;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isDragAndDropTitleDisplayed(){
        return isElementDisplayed(this.dragAndDropTitle, true);
    }

    public String getDragAndDropTitleText(){
        return this.dragAndDropTitle.getText();
    }

    public boolean isRenewButtonDisplayed(){
        return isElementDisplayed(this.renewButton, true);
    }
}
