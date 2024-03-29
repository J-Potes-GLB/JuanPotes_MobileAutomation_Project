package com.projectMobileJP.utils.tests;

import com.projectMobileJP.screens.HomeStartScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();
    public static AndroidDriver driver;

    protected HomeStartScreen homeStartScreen;

    // Methods for environment and capabilities set up
    // Taken from the Framework example shown on the TAE Mobile Training
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }

        openFirstScreen();
    }

    @AfterMethod
    public void quitApp(){
        waitSeconds(1);
        driver.quit();
    }

    public void loadProperties(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }
        catch(IOException e){
            throw new RuntimeException("Error loading the properties file " + PROPERTIES_FILE);
        }
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public HomeStartScreen getHomeStartScreen(){
        return new HomeStartScreen(driver);
    }

    public void openFirstScreen(){
        // Open app on the first screen
        homeStartScreen = getHomeStartScreen();

        // Verify the title of the Home screen is displayed
        Assert.assertTrue(homeStartScreen.isTitleDisplayed());
        Assert.assertTrue(homeStartScreen.areImagesDisplayed());
    }

    public void waitSeconds(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
