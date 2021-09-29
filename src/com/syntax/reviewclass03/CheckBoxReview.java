package com.syntax.reviewclass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxReview {
    public static String url = "http://www.ironspider.ca/forms/checkradio.htm";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> colorCheckBoxes = driver.findElements
                (By.xpath("//input[@name = 'color' and @type = 'checkbox']"));
        System.out.println(colorCheckBoxes.size());

        for (WebElement colorCheckBox : colorCheckBoxes
        ) {
            String color = colorCheckBox.getAttribute("value");
            if (color.equalsIgnoreCase("blue")) {
                colorCheckBox.click();
                Thread.sleep(2000);
                break;
            }

            }


        }
    }

