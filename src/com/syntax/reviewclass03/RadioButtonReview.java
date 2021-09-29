package com.syntax.reviewclass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonReview {

    public static String url = "http://syntaxprojects.com/basic-radiobutton-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement radioBtn = driver.findElement(By.xpath("//input[@value = '5 - 15']"));
        radioBtn.click();
    }
}
