package com.syntax.class11HW5;

/*
Go to http://www.uitestpractice.com/
interact with drag and drop, iframe, double click
click on home
delete one user from the table
go to the next link
click on the ajax link and wait for the text
verify that the text is displayed
go to Form
and fill out everything
go to widgets
upload any file and verify it is uploaded
go to actions and perform all the necessary actions
go to SwitchTo
work with alerts and frames
go to select
perform actions on all dropdowns
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task5 {

    public static WebDriver driver;
    public static String URL = "http://www.uitestpractice.com/";

    //Go to http://www.uitestpractice.com/
    @BeforeMethod
    public void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    //interact with drag and drop
    @Test
    public void dragAndDrop() {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        WebElement droppableHeader = driver.findElement(By.xpath("//div[@id = 'droppable']/p"));
        String droppableHeaderText = droppableHeader.getText();
        String droppableHeaderTextExpected = "Dropped!";
        Assert.assertEquals(droppableHeaderText, droppableHeaderTextExpected, "droppable Header Text is NOT as Expected");
    }

    //interact with double click
    @Test
    public void doubleClick() {
        WebElement doubleClickButton = driver.findElement(By.name("dblClick"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String alertTextExpected = "Double Clicked !!";
        Assert.assertEquals(alertText, alertTextExpected, "Alert Text does NOT show expected text");
    }

    //interact with iframe
    @Test
    public void iframe() {
        WebElement iframea = driver.findElement(By.xpath("//iframe[@name = 'iframe_a']"));
        driver.switchTo().frame(iframea);
        WebElement nameTextBox = driver.findElement(By.cssSelector("input#name"));
        String name = "Andrei";
        nameTextBox.sendKeys(name);
        String enteredName = nameTextBox.getAttribute("value");
        Assert.assertEquals(enteredName, name, "Name wasn't entered");
        driver.switchTo().defaultContent();
        WebElement linkInDefaultFrame = driver.findElement(By.xpath("//a[text()= 'uitestpractice.com']"));
        Assert.assertTrue(linkInDefaultFrame.isDisplayed());
    }
    @Test
    public void table() {
        //click on home
        WebElement homeButton = driver.findElement(By.xpath("//a[text() = 'Home']"));
        homeButton.click();

        //delete one user from the table
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text() = 'DELETE']"));
        WebElement line4 = driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[5]"));
        String line4Text = line4.getText();
        Actions action = new Actions(driver);
        action.moveToElement(deleteButtons.get(2)).click().perform();
        WebElement submitDelete = driver.findElement(By.xpath("//input[@value = 'Delete']"));
        action.moveToElement(submitDelete).click().perform();
        WebElement line3 = driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[4]"));
        String line3Text = line3.getText();
        Assert.assertEquals(line3Text, line4Text, "Deleting was not completed");
    }


    @Test
    public void ajaxLink() {
        /*
    go to the next link
    click on the ajax link and wait for the text
    verify that the text is displayed
     */
        WebElement ajaxCallButton = driver.findElement(By.linkText("AjaxCall"));
        ajaxCallButton.click();
        WebElement ajaxLinkButton = driver.findElement(By.linkText("This is a Ajax link"));
        ajaxLinkButton.click();
        WebElement ajaxLinkTextBlock = driver.findElement(By.xpath("//p[contains(text(), 'Selenium is a portable')]"));
        Assert.assertTrue(ajaxLinkTextBlock.isDisplayed(), "Text is not displayed");
    }

    @Test
    public void form() {
        //go to Form
        //and fill out everything
        WebElement formButton = driver.findElement(By.linkText("Form"));
        formButton.click();
        WebElement firstName = driver.findElement(By.cssSelector("input#firstname"));
        firstName.sendKeys("Bob");
        WebElement lastName = driver.findElement(By.cssSelector("input#lastname"));
        lastName.sendKeys("Dylan");
        List<WebElement> maritalStatusRadioButtons = driver.findElements(By.xpath("//label[@class= 'radio-inline']"));
        for (WebElement status: maritalStatusRadioButtons
             ) {
            if (status.getText().equalsIgnoreCase("Single")) {
                status.click();
            }
        }
        List<WebElement> hobbyRadioButtons = driver.findElements(By.xpath("//label[@class= 'checkbox-inline']"));
        for (WebElement hobby: hobbyRadioButtons
        ) {
            if (hobby.getText().equalsIgnoreCase("Cricket")) {
                hobby.click();
            }
        }
        WebElement countryDD = driver.findElement(By.id("sel1"));
        Select select = new Select(countryDD);
        select.selectByVisibleText("Iceland");
        WebElement dobCalendar = driver.findElement(By.xpath("//input[@placeholder = 'Enter Date of birth']"));
        dobCalendar.click();
        WebElement dobYearDD = driver.findElement(By.className("ui-datepicker-year"));
        Select select1 = new Select(dobYearDD);
        select1.selectByValue("1985");
        WebElement dobMonthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select2 = new Select(dobMonthDD);
        select2.selectByVisibleText("Mar");
        List<WebElement> dobDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement date: dobDates
             ) {
            if(date.getText().equals("18")) {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click()", date);
            }
        }
        WebElement phoneNumber = driver.findElement(By.id("phonenumber"));
        phoneNumber.sendKeys("8008008888");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Dart Vader");
        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("vader666@gmail.gmail");
        WebElement comment = driver.findElement(By.cssSelector("textarea#comment"));
        comment.sendKeys("From another planet");
        WebElement password = driver.findElement(By.cssSelector("input#pwd"));
        password.sendKeys("strongest!password");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type= 'submit']"));
        submitButton.click();
    }

    @Test
    public void widgets() {
        /*
        go to widgets
        upload any file and verify it is uploaded
         */
        WebElement widgetBtn = driver.findElement(By.linkText("Widgets"));
        widgetBtn.click();
        WebElement chooseFileBtn = driver.findElement(By.cssSelector("input#image_file"));
        chooseFileBtn.sendKeys("C:\\Users\\drozz\\Pictures\\picture234345464564565.jpg");
        WebElement uploadBtn = driver.findElement(By.xpath("//input[@value = 'Upload']"));
        uploadBtn.click();
        WebElement confirmMsg = driver.findElement(By.xpath("//p[contains(text(), 'File Successfully Uploaded')]"));
        Assert.assertTrue(confirmMsg.isDisplayed(), "File was NOt uploaded");
    }

    @Test
    public void downloadFile() {
        WebElement widgetBtn = driver.findElement(By.linkText("Widgets"));
        widgetBtn.click();
        WebElement downloadFileBtn = driver.findElement(By.linkText("Download a image"));
        downloadFileBtn.click(); //clicking download button what caused ads popping up
        driver.navigate().refresh(); //refreshing page, pop up vanished
        downloadFileBtn = driver.findElement(By.linkText("Download a image")); //reassign WeElement because page was refreshed
        downloadFileBtn.click(); //performing same action as 3 lines before. Now pop up doesn't come up
    }
    @Test
    public void actions() throws InterruptedException {
        WebElement actions = driver.findElement(By.linkText("Actions"));
        actions.click();
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[@onclick = 'myClickFunction()']"));
        clickMeBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        String alertTextExpected = "Clicked !!";
        Assert.assertEquals(alertText, alertTextExpected, "Alert Text does NOT show expected text");
        Thread.sleep(1000);
        alert.accept();
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@ondblclick = 'myDblClickFunction()']"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(doubleClickBtn).perform();
        String alertText1 = alert.getText();
        System.out.println(alertText1);
        String alertTextExpected1 = "Double Clicked !!";
        Assert.assertEquals(alertText1, alertTextExpected1, "Alert Text does NOT show expected text");
        Thread.sleep(1000);
        alert.accept();
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions1.clickAndHold(draggable).moveToElement(droppable).release(draggable).build().perform();
        WebElement droppableHeader = driver.findElement(By.xpath("//div[@id = 'droppable']/p"));
        String droppableHeaderText = droppableHeader.getText();
        String droppableHeaderTextExpected = "Dropped!";
        Assert.assertEquals(droppableHeaderText, droppableHeaderTextExpected, "droppable Header Text is NOT as Expected");
        WebElement colorBox = driver.findElement(By.cssSelector("div#div2"));
        actions1.moveToElement(colorBox).perform();
        String colorBoxColor = colorBox.getAttribute("style");
        Assert.assertTrue(colorBoxColor.contains("background-color: rgb(0, 128, 0);"), "Cursor was not moved to WebElement");

        List<WebElement> smthLikeTable = draggable.findElements(By.xpath("//ol[@id= 'selectable']/li"));
        for (WebElement element: smthLikeTable
             ) {
            element.click();
            Thread.sleep(500);
            String elementClass = element.getAttribute("class");
            Assert.assertTrue(elementClass.contains("ui-selected"), "Element ws NOt selected");
        }
    }
    @Test
    public void switchTo() throws InterruptedException {
        /*
        go to SwitchTo
        work with alerts and frames
         */
        WebElement switchTo = driver.findElement(By.linkText("Switch to"));
        switchTo.click();
        driver.navigate().refresh();
        WebElement messageUnderAlert = driver.findElement(By.id("demo"));

        WebElement simpleAlert = driver.findElement(By.id("alert"));
        simpleAlert.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(1000);
        alert1.accept();
        Assert.assertEquals(messageUnderAlert.getText(), "You have clicked on ok button in alert window", "Wrong handling with alert");

        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
        Thread.sleep(1000);
        alert1.dismiss();
        Assert.assertEquals(messageUnderAlert.getText(), "You pressed Cancel in confirm window", "Wrong handling with aler");

        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
        Thread.sleep(1000);
        String name = "Andrei";
        alert1.sendKeys(name);
        alert1.accept();
        Assert.assertEquals(messageUnderAlert.getText(), "Hello "+name+"! How are you today?");

        WebElement launchModal = driver.findElement(By.xpath("//button[@data-target = '#myModal']"));
        launchModal.click();
        Thread.sleep(1000);
        WebElement modalOk = driver.findElement(By.xpath("//button[text() ='Ok']"));
        modalOk.click();

        WebElement basicAuthentication = driver.findElement(By.id("basicAuthentication"));
        basicAuthentication.click();

        WebElement iframea = driver.findElement(By.xpath("//iframe[@name = 'iframe_a']"));
        driver.switchTo().frame(iframea);

        WebElement nameTextBox = driver.findElement(By.id("name"));
        nameTextBox.sendKeys("Andrei");
        driver.switchTo().defaultContent();

        WebElement defaultLink = driver.findElement(By.linkText("uitestpractice.com"));
        defaultLink.click();

        WebElement newWindowButton = driver.findElement(By.linkText("Opens in a new window"));
        newWindowButton.click();

//        String firstWindow = driver.getWindowHandle();
//        System.out.println(firstWindow);

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        String firstWindow = iterator.next();
        String secondWindow = iterator.next();
        driver.switchTo().window(secondWindow);
        Thread.sleep(1000);
        driver.switchTo().window(firstWindow);

    }
}

