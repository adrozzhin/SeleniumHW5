package com.syntax.class05HW;

/*
HW2
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task3 {

    public static String url = "https://www.ebay.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement categoriesDD = driver.findElement(By.cssSelector("select[aria-label = 'Select a category for search']"));
        Select select = new Select(categoriesDD);
        List<WebElement> options = select.getOptions();

        for (WebElement option: options
             ) {
            String optionText = option.getText();
            System.out.println(optionText);
        }
        select.selectByVisibleText("Computers/Tablets & Networking");
        WebElement search = driver.findElement(By.id("gh-btn"));
        search.click();
        String title = driver.getTitle();
        System.out.println("---------------------");
        System.out.println("Header is: " + title);
    }
}
