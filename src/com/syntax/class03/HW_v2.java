package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_v2 {
    /*
    Navigate to http://syntaxprojects.com
    Click on start practicing
    click on simple form demo
    enter any text on first text box
    click on show message
    quit the browser
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxprojects.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement start = driver.findElement(By.cssSelector("a#btn_basic_example"));
        start.click();
        Thread.sleep(2000);
        WebElement simpleForm = driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[2]"));
        simpleForm.click();
        Thread.sleep(2000);
        WebElement textBox = driver.findElement(By.cssSelector("input[placeholder='Please enter your Message']"));
        textBox.sendKeys("Money");
        WebElement showText = driver.findElement(By.cssSelector("button[onclick='showInput();']"));
        showText.click();
        Thread.sleep(2000);
        driver.quit();


//        WebElement start = driver.findElement(By.xpath("//a[@id='btn_basic_example']"));
//        start.click();
//        Thread.sleep(2000);
//        WebElement simpleForm = driver.findElement(By.xpath("//a[@href='basic-first-form-demo.php']/parent::div"));
//        simpleForm.click();
//        Thread.sleep(1000);
//        WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
//        textBox.sendKeys("Test text");
//        WebElement showMsg = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
//        showMsg.click();
//        Thread.sleep(3000);
//        driver.quit();

    }
}
