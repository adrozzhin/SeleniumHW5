package com.syntax.class09;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesWithPagination extends CommonMethods{
    public static void main(String[] args) {
        setUp("http://syntaxprojects.com/table-pagination-demo.php");
        maximizeWindow();
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
        WebElement nextButton = driver.findElement(By.xpath("//a[@class = 'next_link']"));

        boolean flag = true;
        while (flag) {
            for (WebElement tableRow: tableRows
            ) {
                String rowText = tableRow.getText();
                if(rowText.contains("Archy J")) {
                    flag=false;
                    System.out.println(rowText);
                    break;
                }
            }
            if(flag) {
                nextButton.click();
            }

        }
    }
}
