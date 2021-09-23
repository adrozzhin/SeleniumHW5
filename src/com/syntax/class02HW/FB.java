package com.syntax.class02HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB {
    /*
    navigate to fb.com
    click on create new account
    fill up all the textboxes
    click on sign up button
    close the pop up
    close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

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

        WebElement signUp = driver.findElement(By.name("websubmit"));
        signUp.click();

        WebElement exit = driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']"));
        exit.click();
    }
}
