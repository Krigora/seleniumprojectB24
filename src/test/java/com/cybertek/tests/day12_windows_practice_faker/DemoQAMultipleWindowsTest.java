package com.cybertek.tests.day12_windows_practice_faker;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class DemoQAMultipleWindowsTest {

    WebDriver drive;
    String url = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp() {
        drive = getDriver("chrome");
        drive.manage().window().maximize();
        drive.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        drive.get(url);
    }

    /*
    Click on New Window Button
     Switch to new Window
     Locate and print the message
     Close the window
     Go back to main window
     */

    @Test
    public void newWindowTest() {
        WebElement newWindowBtn = drive.findElement(By.cssSelector("#windowButton"));
        newWindowBtn.click();

        // driver.close(); // close currently active window
        // driver.quit(); // closes all opened windows in same session

        Set<String> windowHandlesSet = drive.getWindowHandles();
        String parentWindowHandle = drive.getWindowHandle(); //store current window handle

        for(String windowHandle : windowHandlesSet) {
            if (!windowHandle.equals(parentWindowHandle)) {
                drive.switchTo().window(windowHandle);
            }
        }

        WebElement header = drive.findElement(By.cssSelector("#sampleHeading"));
        System.out.println("header text = " + header.getText());

    }
}
