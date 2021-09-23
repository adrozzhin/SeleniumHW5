package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo {

    public static String url = "http://syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> optionCheckBoxes = driver.findElements(By.xpath("//input[@class= 'cb1-element']"));
        int size = optionCheckBoxes.size();
        System.out.println(size);

        for (WebElement option: optionCheckBoxes
             ) {
            String text = option.getAttribute("value");
            if(text.equalsIgnoreCase("Option-2")) {
                option.click();
                Thread.sleep(1000);
                break;
            }

        }
    }
}
