package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxesWithImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/checkboxes";
        //implicit wait command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //locate first checkbox using name or id , xpath
        //<input type="checkbox" name="checkbox1" id="box1">
        WebElement checkbox1 = driver.findElement(By.name("checkbox1"));
        checkbox1.click();

        //uncheck second checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        checkbox2.click();
        System.out.println("checkbox 1 is selected ? = " + checkbox1.isSelected());
        System.out.println("checkbox 2 is selected ? = " + checkbox2.isSelected());

        if (!checkbox1.isSelected()){
            checkbox1.click();
        } else {
            System.out.println("Checkbox 1 is already selected");
        }


        }
    }

