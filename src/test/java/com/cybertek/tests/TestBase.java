package com.cybertek.tests;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;
    protected Faker faker = new Faker();
    protected Actions actions ;
    //   protected WebDriverWait wait = new WebDriverWait(driver,20);

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        actions = new Actions(driver);

    }
    @AfterMethod
    public void TearDown(){
        Driver.closeDriver();
    }

}
