package com.syntax.class02HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parabank {
    /*
    navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    fill out the form
    click on register
    close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Ivan");
        driver.findElement(By.id("customer.lastName")).sendKeys("Ivanov");
        driver.findElement(By.id("customer.address.street")).sendKeys("1000 Watt Ave");
        driver.findElement(By.id("customer.address.city")).sendKeys("San Francisco");
        driver.findElement(By.id("customer.address.state")).sendKeys("CA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("95555");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9168889955");
        driver.findElement(By.id("customer.ssn")).sendKeys("000-1111-2222");
        driver.findElement(By.id("customer.username")).sendKeys("Testuser52484");
        driver.findElement(By.id("customer.password")).sendKeys("Parol1345544");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Parol1345544");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        Thread.sleep(5000);
        //driver.quit();
    }
}
