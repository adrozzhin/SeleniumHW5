package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {

    public static String url = "http://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement daysDD = driver.findElement(By.id("select-demo"));
        Select select = new Select(daysDD);
        select.selectByIndex(3);
        Thread.sleep(1000);
        select.selectByVisibleText("Thursday");
        Thread.sleep(1000);
        select.selectByValue("Sunday");
        List<WebElement> alloptions = select.getOptions();
        int size = alloptions.size();
        System.out.println(size);

        for (int i = 0; i < alloptions.size(); i++) {
            String optionText = alloptions.get(i).getText();
            System.out.println(optionText);
            select.selectByIndex(i);
            Thread.sleep(1000);
        }

    }
}
