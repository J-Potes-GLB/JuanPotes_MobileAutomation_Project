package com.projectMobileJP.tests;

import com.projectMobileJP.screens.SwipeScreen;
import com.projectMobileJP.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {
    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void openSwipeScreen(){
        swipeScreen = homeStartScreen.clickSwipeMenuButton();

        Assert.assertTrue(swipeScreen.isSwipeHorizontalTitleDisplayed());
        Assert.assertEquals(swipeScreen.getSwipeSwipeHorizontalTitleText(), SwipeScreen.SWIPE_TITLE_TEXT);
        Assert.assertTrue(swipeScreen.isSwipeVerticalSubtitleDisplayed());
        Assert.assertEquals(swipeScreen.getSwipeVerticalSubtitleText(), SwipeScreen.SWIPE_SUBTITLE_TEXT);
    }

    @Test
    public void executeSwipingOfCard(){
        swipeScreen.swipeCardLeft();
        swipeScreen.swipeCardLeft();
    }
}
