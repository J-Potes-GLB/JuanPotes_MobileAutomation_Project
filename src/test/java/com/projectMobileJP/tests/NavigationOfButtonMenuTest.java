package com.projectMobileJP.tests;

import com.projectMobileJP.screens.*;
import com.projectMobileJP.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationOfButtonMenuTest extends BaseTest {
    HomeStartScreen homeStartScreen;

    @BeforeMethod
    public void precondition(){
        // Open app on the first screen
        homeStartScreen = getHomeStartScreen();

        // Verify the title of the Home screen is displayed
        Assert.assertTrue(homeStartScreen.isTitleDisplayed());
        Assert.assertTrue(homeStartScreen.areImagesDisplayed());
    }

    @Test
    public void navigateBottomMenu(){
        // Click on the Webview button from the bottom menu
        WebviewScreen webviewScreen = homeStartScreen.clickWebviewMenuButton();

        // Verify that elements of the Webview screen are displayed
//        webviewScreen.waitSeconds(7);
        Assert.assertTrue(webviewScreen.isGetStartedButtonDisplayed());
        Assert.assertEquals(webviewScreen.getGetStartedButtonText(), WebviewScreen.GET_STARTED_TEXT);
        Assert.assertTrue(webviewScreen.isSearchButtonDisplayed());
        Assert.assertEquals(webviewScreen.getSearchButtonText(), WebviewScreen.SEARCH_BUTTON_TEXT);

        // Click on the Login button from the bottom menu
        LoginScreen loginScreen = webviewScreen.clickLoginMenuButton();

        // Verify that elements of the Login screen are displayed
        Assert.assertTrue(loginScreen.isLoginTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getLoginTabButtonText(), LoginScreen.LOGIN_TAB_TEXT);
        Assert.assertTrue(loginScreen.isSignupTabButtonDisplayed());
        Assert.assertEquals(loginScreen.getSignupTabButtonText(), LoginScreen.SIGNUP_TAB_TEXT);

        // Click on the Forms button from the bottom menu
        FormsScreen formsScreen = loginScreen.clickFormsMenuButton();

        // Verify that elements of the Forms screen are displayed
        Assert.assertTrue(formsScreen.isFormComponentsTitleDisplayed());
        Assert.assertEquals(formsScreen.getFormTitleText(), FormsScreen.FORM_TITLE_TEXT);
        Assert.assertTrue(formsScreen.isDropdownDisplayed());
        Assert.assertEquals(formsScreen.getDropdownText(), FormsScreen.DROPDOWN_DEFAULT_TEXT);

        // Click on the Swipe button from the bottom menu
        SwipeScreen swipeScreen = formsScreen.clickSwipeMenuButton();

        // Verify that elements of the Swipe screen are displayed

        // Click on the Drag button from the bottom menu

        // Verify that elements of the Drag screen are displayed
    }
}
