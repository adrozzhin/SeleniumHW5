package com.syntax.class06HW;

/*
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement firstButtonAlert = driver.findElement(By.cssSelector("button[class = 'btn btn-default']"));
        firstButtonAlert.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.accept();

        WebElement secondButtonAlert = driver.findElement(By.cssSelector("button[onclick = 'myConfirmFunction()']"));
        secondButtonAlert.click();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.dismiss();

        WebElement thirdButtonAlert = driver.findElement(By.cssSelector("button[onclick = 'myPromptFunction()']"));
        thirdButtonAlert.click();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.sendKeys("Andrei");
        alert.accept();
    }
}

