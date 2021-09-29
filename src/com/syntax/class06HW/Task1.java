package com.syntax.class06HW;

/*
Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the logo SYNTAX on the left iframe is displayed
verify enroll today button on the right iframe is enabled
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public  static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame("FrameOne");
        WebElement logo = driver.findElement(By.xpath("//img[@alt = 'Syntax Technologies Logo']"));
        if (logo.isDisplayed()) {
            System.out.println("Logo in iframe one is displayed");
        } else {
            System.out.println("Logo in iframe one is NOT displayed");
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("FrameTwo");
        WebElement enroll = driver.findElement(By.xpath("//div[text() = 'Enroll today'  and @class = 'text-block-2']"));
        if (enroll.isDisplayed()) {
            System.out.println("Enroll button in iframe two is displayed");
        } else {
            System.out.println("Enroll button in iframe two is NOT displayed");
        }


    }
}
