package com.syntax.class05HW;

/*
HW1
Go to facebook sign up page
Fill out the whole form
Click signup
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
        createAccount.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Johny");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Bravo");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("testmail@mail.com");
        WebElement emailconfirm = driver.findElement(By.name("reg_email_confirmation__"));
        emailconfirm.sendKeys("testmail@mail.com");
        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("psw123/*-");
        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthsDD);
        selectMonth.selectByValue("8");
        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        selectDay.selectByValue("5");
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        selectYear.selectByValue("1985");
        List<WebElement> genders = driver.findElements(By.cssSelector("input[name = 'sex']"));
        for (WebElement gender : genders
        ) {
            String value = gender.getAttribute("value");
            if (value.equalsIgnoreCase("2")) {
                gender.click();
                break;
            }
        }
        WebElement signUp = driver.findElement(By.name("websubmit"));
        signUp.click();
        Thread.sleep(3000);
        driver.quit();
    }
}

