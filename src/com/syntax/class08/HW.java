package com.syntax.class08;

/*
go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable
verify the textbox is enabled
enter text and click disable
verify the textbox is disabled
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[label = 'blah']")));

        WebElement checkbox = driver.findElement(By.cssSelector("input[label = 'blah']"));
        checkbox.click();

        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick = 'swapCheckbox()']/following-sibling::p")));

        WebElement checkBoxGoneText = driver.findElement(By.xpath("//button[@onclick = 'swapCheckbox()']/following-sibling::p"));
        if(checkBoxGoneText.isDisplayed() && checkBoxGoneText.getText().equals("It's gone!")) {
            System.out.println("Expected text: " + checkBoxGoneText.getText() + " is displayed");
        } else if (checkBoxGoneText.isDisplayed() && !checkBoxGoneText.getText().equals("It's gone!")) {
            System.out.println("UNexpected text: " + checkBoxGoneText.getText() + " is displayed");
        } else {
            System.out.println("Text is not displayed");
        }
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()' and text() = 'Enable']"));
        enableButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type ='text']")));

        WebElement textBox = driver.findElement(By.xpath("//input[@type ='text']"));

        if(textBox.isEnabled()) {
            System.out.println("Textbox is enabled");
        } else {
            System.out.println("Textbox is disabled");
        }

        textBox.sendKeys("Some text");
        WebElement disableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()' and text() = 'Disable']"));
        disableButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));

        if(textBox.isEnabled()) {
            System.out.println("Textbox is enabled after clicking 'Disable' button");
        } else {
            System.out.println("Textbox is disabled after clicking 'Disable' button");
        }

    }
}
