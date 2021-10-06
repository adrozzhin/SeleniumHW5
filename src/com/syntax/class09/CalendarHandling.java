package com.syntax.class09;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class CalendarHandling extends CommonMethods {
    public static void main(String[] args) {
        setUp("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        implicitlyWait20sec();
        maximizeWindow();
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement fromCalender = driver.findElement(By.id("calFromDate"));
        fromCalender.click();

        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonth = new Select(monthDD);
        selectMonth.selectByVisibleText("Oct");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement fromDate: fromDates
             ) {
            if(fromDate.getText().equals("21")) {
                fromDate.click();
                break;
            }
        }

    }
}
