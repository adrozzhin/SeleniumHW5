package com.syntax.class04HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
    HRMS Application Negative Login:
    Open chrome browser
    Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Enter valid username Admin
    Leave password field empty
    Click on login button
    Verify error message with text “Password cannot be empty” is displayed.
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));

        userName.sendKeys("Admin");
        WebElement login = driver.findElement(By.cssSelector("input#btnLogin"));
        login.click();
        WebElement alertmsg = driver.findElement(By.xpath("//span[text() = 'Password cannot be empty']"));
        if (alertmsg.isDisplayed()) {
            System.out.println("Alert message is displayed");
        } else {
            System.out.println("Alert message is NOT displayed");
        }

    }
}
