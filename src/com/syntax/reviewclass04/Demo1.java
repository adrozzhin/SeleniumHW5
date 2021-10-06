package com.syntax.reviewclass04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static String url = "https://demoqa.com/nestedframes";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.switchTo().frame(1);
        driver.switchTo().frame(0);

        WebElement childFrame = driver.findElement(By.xpath("//p[text() = 'Child Iframe']"));
        String childframeText = childFrame.getText();
        System.out.println(childframeText);
    }
}
