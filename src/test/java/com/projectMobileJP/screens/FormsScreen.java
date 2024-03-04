package com.projectMobileJP.screens;

import com.projectMobileJP.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {
    public static final String FORM_TITLE_TEXT = "Form components";
    public static final String DROPDOWN_DEFAULT_TEXT = "Select an item...";

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Form components\")")
    private WebElement formComponentsTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"text_input\")")
    private WebElement dropdown;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isFormComponentsTitleDisplayed(){
        waitUntilVisibleElement(this.formComponentsTitle);
        return this.formComponentsTitle.isDisplayed();
    }

    public String getFormTitleText(){
        return this.formComponentsTitle.getText();
    }

    public boolean isDropdownDisplayed(){
        waitUntilVisibleElement(this.dropdown);
        return this.dropdown.isDisplayed();
    }

    public String getDropdownText(){
        return this.dropdown.getText();
    }
}
