package com.syntax.reviewclass02;

/*
Open chrome browser
Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Verify error message with text “Password cannot be empty” is not displayed
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        Thread.sleep(2000);
//        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
//        userName.sendKeys("Admin");
//        WebElement login = driver.findElement(By.cssSelector("input#btnLogin"));
//        login.click();
        boolean present;

        try {
            driver.findElement(By.xpath("//span[text() = 'Password cannot be empty']"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        System.out.println(present);
        if (present==true) {
            System.out.println("'Password cannot be empty' message is exist and displayed on the page");
        } else {
            System.out.println("'Password cannot be empty' message is NOT exist and displayed on the page");
        }
    }
}