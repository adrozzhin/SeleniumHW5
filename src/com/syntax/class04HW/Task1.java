package com.syntax.class04HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
    Task
    Open chrome browser
    Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Enter valid username and password (username - Admin, password - Hum@nhrm123)
    Click on login button
    Then verify Syntax Logo is displayed.
     */


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.cssSelector("input[name = 'txtPassword']"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.cssSelector("input#btnLogin"));
        login.click();
        WebElement logo = driver.findElement(By.cssSelector("img[src $= 'syntax.png']"));
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed");
        } else {
            System.out.println("Logo is NOT displayed");
        }
    }
}