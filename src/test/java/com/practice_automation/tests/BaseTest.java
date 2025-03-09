package com.practice_automation.tests;

import com.practice_automation.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends BasePage {

    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToBasePage(), "Ошибка перехода на тестируемую страницу");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            closeBrowser();
        }
    }
}


