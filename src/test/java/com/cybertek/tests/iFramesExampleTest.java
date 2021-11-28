package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class iFramesExampleTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/iframe";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void iframeTest(){
        // switch to the frame by.id

        //<iframe id="mce_0_ifr" frameborder="0" allowtransparency="true" title="Rich Text Area" class="tox-edit-area__iframe"></iframe>
        driver.switchTo().frame("mce_0_ifr");

        //now we are focused on the iframe

        //<body id="tinymce" class="mce-content-body " data-id="mce_0" aria-label="Rich Text Area. Press ALT-0 for help." contenteditable="true" spellcheck="false"><p>Your content goes here.</p></body>
        WebElement commentField = driver.findElement(By.id("tinymce"));
        System.out.println("Comment text = " + commentField.getText());
        commentField.clear();
        commentField.sendKeys("Hello Hello");

        // go out from iframe back to main content:
        driver.switchTo().defaultContent();
    }

    @Test
    public void multipleFramesTest() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //find out count of frames on this page
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        System.out.println("count of frames = " + frames.size());

        //Switch to bottom frame by name/id
        // <frame src="/frame_bottom" scrolling="no" name="frame-bottom" cd_frame_id_="a048b0ae9475249164af964ba32fe9fb">
        driver.switchTo().frame("frame-bottom");
        WebElement bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Text of bottom frame = " + bodyElem.getText());

        //go out from bottom frame to main level
        driver.switchTo().defaultContent();

        //switch to first frame( index 0)
        driver.switchTo().frame(0).switchTo().frame(1);
        bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Frame 0 body elem text = " + bodyElem.getText());

        //go back parent frame then back to default content
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        //locate third child frame using WebElement. findElement method and xpath
        //<frame src="/frame_right" scrolling="no" name="frame-right" cd_frame_id_="95193a500667645c7e7e1be1cb474e0c">
        driver.switchTo().frame(0).switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
        bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Frame right body elem text = " + bodyElem.getText());
    }




    }
