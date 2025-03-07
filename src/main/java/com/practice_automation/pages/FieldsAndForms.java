package com.practice_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
        WebElement password = driver.findElement(By.xpath("//label/input[@type='password']"));
        password.sendKeys(inputPassword);
        return password;
    }

    public String getAssertInputPassword() {
        WebElement nameInput = getInputPasswordField();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", nameInput);
    }

    public WebElement getInputRadiobutton() {
        WebElement radiobutton = driver.findElement(By.cssSelector("input[value = 'Yellow']"));
        radiobutton.click();
        return radiobutton;
    }

    public WebElement getInputCheckBoxMilk() {
        WebElement checkboxMilk = driver.findElement(By.xpath("//input[@value = 'Milk']"));
        checkboxMilk.click();
        return checkboxMilk;
    }

    public WebElement getInputCheckboxCoffee() {
        WebElement checkboxCoffee = driver.findElement(By.cssSelector("input[value = 'Coffee']"));
        checkboxCoffee.click();
        return checkboxCoffee;
    }



}
