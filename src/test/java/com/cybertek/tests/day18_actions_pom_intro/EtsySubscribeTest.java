package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EtsySubscribeTest extends TestBase {
    /*
    Goto Etsy homepage
Scroll down
Generate random email and enter into subscribe box
Click on Subscribe
Verify "Great! We've sent you an email to confirm your subscription." is displayed
     */

 @Test
 public void randomEmailSubscribeTest() {

  driver.get(ConfigurationReader.getProperty("etsy.url"));

 // JavascriptExecutor js = (JavascriptExecutor) driver;
 // js.executeScript("window.scrollBy(0, 5000)");
 // ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 5000)")

  BrowserUtils.scrollDown(4000);

  //<input class="wt-input-btn-group__input wt-text-body-01" id="email-list-signup-email-input" placeholder="Enter your email" name="email_address" data-email-list-signup-email-input="">
  WebElement emailField = driver.findElement(By.name("email_address"));

  // Faker faker = new Faker(); declared in TestBase
  emailField.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

  BrowserUtils.sleep(5);

  //<div class="wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01" role="alert" aria-live="polite" data-success-signed-out="" data-submission-response="">
  //                Great! We've sent you an email to confirm your subscription.
  //            </div>

  WebElement successMsg = driver.findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
  assertTrue(successMsg.isDisplayed());
  assertEquals(successMsg.getText(), "Great! We've sent you an email to confirm your subscription.");

 }

 }
