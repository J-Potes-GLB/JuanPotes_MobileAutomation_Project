package com.projectMobileJP.tests;

import com.projectMobileJP.screens.HomeStartScreen;
import com.projectMobileJP.screens.WebviewScreen;
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
        // precondition();

        // Click on the Webview button from the bottom menu
        WebviewScreen webviewScreen = homeStartScreen.clickWebviewButton();

        // Verify that elements of the Webview screen are displayed

        // Click on the Login button from the bottom menu

        // Verify that elements of the Login screen are displayed

        // Click on the Forms button from the bottom menu

        // Verify that elements of the Forms screen are displayed

        // Click on the Swipe button from the bottom menu

        // Verify that elements of the Swipe screen are displayed

        // Click on the Drag button from the bottom menu

        // Verify that elements of the Drag screen are displayed
    }
}
