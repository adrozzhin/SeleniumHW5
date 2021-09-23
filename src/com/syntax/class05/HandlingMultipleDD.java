package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingMultipleDD {
    public static String url = "http://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement stateDD = driver.findElement(By.id("multi-select"));
        Select select = new Select(stateDD);
        boolean isMultipal = select.isMultiple();
        System.out.println(isMultipal);

        if(isMultipal) {
            List<WebElement> options = select.getOptions();
            for (WebElement option:options
                 ) {
                String optionText = option.getText();
                select.selectByVisibleText(optionText);
                Thread.sleep(1000);
            }
        }
        select.deselectAll();


    }
}
