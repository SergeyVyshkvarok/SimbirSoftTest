package com.practice_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FieldsAndForms extends BasePage {

    public String getPageTitle() {
        return driver.getTitle();
    }

//    public WebElement getInputNameField() {
//
//
//        return nameInput;
//    }

    public WebElement getInputNameField() {
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='name-input']"));
        nameInput.sendKeys(inputText);
        return nameInput;
    }

    public String getAssertInputName() {
        WebElement nameInput = getInputNameField();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", nameInput);
    }

    public WebElement getInputPasswordField() {
        WebElement passwordField = driver.findElement(By.xpath("//label/input[@type='password']"));
        passwordField.sendKeys(inputPassword);
        return passwordField;
    }

    public String getAssertInputPassword() {
        WebElement nameInput = getInputPasswordField();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", nameInput);
    }

    public WebElement getSElectRadiobutton() {
        WebElement radiobutton = driver.findElement(By.xpath("//input[@value='Yellow']"));

        return radiobutton;
    }

    public WebElement clickCheckBoxMilkAndCheckCondition() {
        WebElement checkboxMilk = driver.findElement(By.xpath("//input[@value = 'Milk']"));
        checkboxMilk.click();
        return checkboxMilk;
    }

    public WebElement clickCheckBoxCoffeeAndCheckCondition() {
        WebElement checkboxCoffee = driver.findElement(By.xpath("//input[@value = 'Coffee']"));

        return checkboxCoffee;
    }



}
