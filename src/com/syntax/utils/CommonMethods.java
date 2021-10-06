package com.syntax.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;

    public static void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
    public static void maximizeWindow()  {
        driver.manage().window().maximize();
    }
    public static void navigateToURL(String url) {
        driver.navigate().to(url);
    }
    public static void navigateBack() {
        driver.navigate().back();
    }
    public static void navigateForward() {
        driver.navigate().forward();
    }
    public static void navigateRefresh() {
        driver.navigate().refresh();
    }
    public static void getUrl(String url) {
        driver.get(url);
    }
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public static String getTitle() {
        return driver.getTitle();
    }
    public static void implicitlyWait20sec() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


}
