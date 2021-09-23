package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.amazon.com/");
        String url = driver1.getCurrentUrl();
        System.out.println(url);
        String title = driver1.getTitle();
        System.out.println(title);
        driver1.quit();
    }
}
