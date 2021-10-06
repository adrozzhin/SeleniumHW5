package com.syntax.class07HW;

/*
navigate to http://www.uitestpractice.com/Students/Contact
click on the link
get text
print out in the console
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task2 {
    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement ajaxLink = driver.findElement(By.linkText("This is a Ajax link")); ////a[@data-ajax-loading='#LoadImage']
        ajaxLink.click();
        WebElement text = driver.findElement(By.xpath("//div[@class = 'ContactUs']/*"));
        System.out.println("Text: " + text.getText());
    }
}
