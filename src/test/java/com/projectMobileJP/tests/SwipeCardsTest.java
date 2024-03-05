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
        // Click on Swipe menu button
        swipeScreen = homeStartScreen.clickSwipeMenuButton();

        // Verify elements of SwipeScreen are displayed
        Assert.assertTrue(swipeScreen.isSwipeHorizontalTitleDisplayed());
        Assert.assertEquals(swipeScreen.getSwipeSwipeHorizontalTitleText(), SwipeScreen.SWIPE_TITLE_TEXT);
        Assert.assertTrue(swipeScreen.isSwipeVerticalSubtitleDisplayed());
        Assert.assertEquals(swipeScreen.getSwipeVerticalSubtitleText(), SwipeScreen.SWIPE_SUBTITLE_TEXT);
    }

    @Test
    public void executeSwipingOfCard(){
        // Verify first card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(1));
        Assert.assertEquals(swipeScreen.getTitleCardText(1), SwipeScreen.TITLE_CARD_1_TEXT);

        // Execute swipe
        swipeScreen.swipeCardRight();

        // Verify second card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(2));
        Assert.assertEquals(swipeScreen.getTitleCardText(2), SwipeScreen.TITLE_CARD_2_TEXT);
        // Verify first card title is NOT displayed
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(1));

        // Execute swipe
        swipeScreen.swipeCardRight();

        // Verify third card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(3));
        Assert.assertEquals(swipeScreen.getTitleCardText(3), SwipeScreen.TITLE_CARD_3_TEXT);
        // Verify second card title is NOT displayed
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(2));

        // Execute swipe
        swipeScreen.swipeCardRight();

        // Verify fourth card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(4));
        Assert.assertEquals(swipeScreen.getTitleCardText(4), SwipeScreen.TITLE_CARD_4_TEXT);
        // Verify third card title is NOT displayed
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(3));

        // Execute swipe
        swipeScreen.swipeCardRight();

        // Verify fifth card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(5));
        Assert.assertEquals(swipeScreen.getTitleCardText(5), SwipeScreen.TITLE_CARD_5_TEXT);
        // Verify fourth card title is NOT displayed
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(4));

        // Execute swipe
        swipeScreen.swipeCardRight();

        // Verify sixth card title is displayed
        Assert.assertTrue(swipeScreen.isTitleCardDisplayed(6));
        Assert.assertEquals(swipeScreen.getTitleCardText(6), SwipeScreen.TITLE_CARD_6_TEXT);

        // Verify all other card titles are NOT displayed
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(5));
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(4));
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(3));
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(2));
        Assert.assertFalse(swipeScreen.isTitleCardDisplayed(1));
    }
}
