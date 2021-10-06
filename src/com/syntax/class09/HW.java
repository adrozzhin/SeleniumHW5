package com.syntax.class09;
/*
Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser
 */

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HW extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        maximizeWindow();
        implicitlyWait20sec();
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement leaveButton = driver.findElement(By.linkText("Leave"));
        leaveButton.click();
        WebElement leaveList = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveList.click();
        WebElement calendarFrom = driver.findElement(By.id("calFromDate"));
        calendarFrom.click();
        WebElement monthDDFrom = driver.findElement(By.className("ui-datepicker-month"));
        monthDDFrom.click();
        Select selectFrom = new Select(monthDDFrom);
        selectFrom.selectByVisibleText("Nov");
        List<WebElement> datesFrom = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement dateFrom  : datesFrom
             ) {
            if(dateFrom.getText().equals("10")) {
                dateFrom.click();
            }
        }

        WebElement calendarTo = driver.findElement(By.id("calToDate"));
        calendarTo.click();
        WebElement monthDDTo= driver.findElement(By.className("ui-datepicker-month"));
        monthDDTo.click();
        Select selectTo = new Select(monthDDTo);
        selectTo.selectByVisibleText("Nov");
        List<WebElement> datesTo = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement dateTo  : datesTo
        ) {
            if(dateTo.getText().equals("15")) {
                dateTo.click();
            }
        }

        WebElement rejectedCB = driver.findElement(By.xpath("//label[text() = 'Rejected']/following-sibling::input[1]"));
        rejectedCB.click();
        WebElement cancelledCB = driver.findElement(By.xpath("//label[text() = 'Cancelled']/following-sibling::input[1]"));
        cancelledCB.click();
        WebElement pendingCB = driver.findElement(By.xpath("//label[text() = 'Pending Approval']/following-sibling::input[1]"));
        pendingCB.click();

        WebElement subUnitDD = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select select = new Select(subUnitDD);
        select.selectByVisibleText("IT Support");
        WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
