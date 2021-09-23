package com.syntax.class05HW;

/*
TC 1: Facebook dropdown verification
Open chrome browser
Go to "https://www.facebook.com"
click on create new account
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth
Quit browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement newAcc = driver.findElement(By.xpath("//a[@data-testid = \"open-registration-form-button\"]"));
        newAcc.click();
        Thread.sleep(2000);

        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthsDD);
        List<WebElement> monthOptions = selectMonth.getOptions();
        if (monthOptions.size()==12) {
            System.out.println("Month dropdown is correct, quantity of months is: " + monthOptions.size());
        } else {
            System.out.println("Month dropdown is NOT correct, quantity of months is: " + monthOptions.size());
        }

        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> dayOptions = selectDay.getOptions();
        if (dayOptions.size()==31) {
            System.out.println("Day dropdown is correct, quantity of days is: " + dayOptions.size());
        } else {
            System.out.println("Day dropdown is NOT correct, quantity of days is: " + dayOptions.size());
        }

        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> yearOptions = selectYear.getOptions();
        if (yearOptions.size()==115) {
            System.out.println("Year dropdown is correct, quantity of years is: " + yearOptions.size());
        } else {
            System.out.println("Year dropdown is NOT correct, quantity of years is: " + yearOptions.size());
        }
        selectMonth.selectByVisibleText("Sep");
        selectDay.selectByValue("26");
        selectYear.selectByValue("1990");
        Thread.sleep(3000);
        driver.quit();
    }
}
