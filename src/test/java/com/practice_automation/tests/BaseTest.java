package com.practice_automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/form-fields/");
    }

    @AfterSuite
    public void tearDown() {
       // driver.quit();
    }
}
