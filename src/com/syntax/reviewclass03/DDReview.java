package com.syntax.reviewclass03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDReview {

    public static String url = "http://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}
