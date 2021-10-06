package com.syntax.class07HW;

/*
Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify the title is displayed
Print out the title of the all pages
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task1_v3 {
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id = 'tabButton']"));
        WebElement newWindowButton = driver.findElement(By.xpath("//button[@id = 'windowButton']"));
        WebElement newWindowMessageButton = driver.findElement(By.xpath("//button[@id = 'messageWindowButton']"));
        newTabButton.click();
        newWindowButton.click();
        newWindowMessageButton.click();

        String mainPageHandle = driver.getWindowHandle();
        System.out.println("the main page Handle is: " +mainPageHandle);

        Set<String> allHandles = driver.getWindowHandles();
        int size = allHandles.size();



        Iterator<String> it = allHandles.iterator();
        String[] handleArray = new String[size];
        int i = 0;


        while (it.hasNext()) {
            handleArray[i] = it.next();
            System.out.println(handleArray[i]);
            i++;
        }




        driver.switchTo().window(handleArray[1]);
        WebElement newTabText = driver.findElement(By.id("sampleHeading"));
        System.out.println("New tab text: " + newTabText.getText());

        driver.switchTo().window(handleArray[2]);
        WebElement newWindowText = driver.findElement(By.id("sampleHeading"));
        System.out.println("New window text: " + newWindowText.getText());
//
//        driver.switchTo().window(newWindowMessageHandle);
//        WebElement newWindowMessageText = driver.findElement(By.xpath("//body"));
//        System.out.println("New Window Message text: " + newWindowMessageText.getText());
//        driver.switchTo().window(mainPageHandle);
//        String mainTitle = driver.getTitle();
//        if(mainTitle.isEmpty()) {
//            System.out.println("There is NO title on the main page");
//        } else {
//            System.out.println("There is a title displayed on the main page: " + mainTitle);
//        }
//        driver.switchTo().window(newTabHandle);
//        String newTabTitle = driver.getTitle();
//        if(newTabTitle.isEmpty()) {
//            System.out.println("There is NO title on the New Tab page");
//        } else {
//            System.out.println("There is a title displayed on the New Tab page: " + newTabTitle);
//        }
//        driver.switchTo().window(newWindowHandle);
//        String newWindowTitle = driver.getTitle();
//        if(newWindowTitle.isEmpty()) {
//            System.out.println("There is NO title on the New Window page");
//        } else {
//            System.out.println("There is a title displayed on the New Window page: " + newWindowTitle);
//        }
//        driver.switchTo().window(newWindowMessageHandle);
//        String newWindowMessageTitle = driver.getTitle();
//        if(newWindowMessageTitle.isEmpty()) {
//            System.out.println("There is NO title on the New Window Message page");
//        } else {
//            System.out.println("There is a title displayed on the New Window Message page: " + newWindowMessageTitle);
//        }
    }
}
