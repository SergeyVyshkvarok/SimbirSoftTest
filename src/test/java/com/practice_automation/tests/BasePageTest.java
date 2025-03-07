package com.practice_automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasePageTest extends BaseTest {

    @Test
    public void testBasePage() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Form Fields | Practice Automation");
    }

    @Test(priority = 1, description = "Заполнение поля Name")
    public void testInputNameField() {
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='name-input']"));
        String inputText = "Сергей";
        nameInput.sendKeys(inputText);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeToBe(nameInput, "Сергей", "Сергей"));
//        String actualText = nameInput.getAttribute("Сергей");
//        Assert.assertEquals(actualText, inputText, "Текст в поле не совпадает с ожидаемым");

    }

    @Test(priority = 2, description = "Заполнение поля Password")
    public void testInputPasswordField() {
        WebElement password = driver.findElement(By.xpath("//label/input[@type='password']"));
        password.sendKeys("12345");
        //Assert.assertEquals(password, "12345");

    }

    @Test(priority = 3, description = "Выбор чекбоксов")
    public void testInputCheckBoxes() {
        WebElement checkboxMilk = driver.findElement(By.xpath("//input[@value = 'Milk']"));
        checkboxMilk.click();
        WebElement checkboxCoffee = driver.findElement(By.cssSelector("input[value = 'Coffee']"));
        checkboxCoffee.click();
    }

    @Test(priority = 4, description = "Выбор radiobutton")
    public void testInputRadiobutton() {
        WebElement radiobutton = driver.findElement(By.cssSelector("input[value = 'Yellow']"));
        radiobutton.click();
    }

    @Test(priority = 5, description = "Выбор элемента выпадающего меню")
    public void testDropDownMenu() {
        WebElement dropDownMenu = driver.findElement(By.id("automation"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Yes");
    }

    @Test(priority = 6, description = "Заполнения поля email")
    public void testFillingEmailField() {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("sergey.vyshkvarok@gmail.com");
    }

    @Test(priority = 7, description = "Заполнение поля Message")
    public void testFillingMessageField() {
        WebElement ulElement = driver.findElement(By.xpath("//form/ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        //Определение количества инструментов, описанных в пункте Automation tools
        int count = liElements.size();
        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='message']"));

        //Определение  инструмента из списка Automation tools, содержащего наибольшее количество символов
        String maxSimbols = "";
        int maxLength = 0;
        for (WebElement li:liElements) {
            if (li.getText().length() > maxLength) {
                maxLength = li.getText().length();
                maxSimbols = li.getText();
            }
        }
        messageField.sendKeys("Количество инструментов, описанных в пункте Automation tools: " + count);
        System.out.println();
        messageField.sendKeys("\nИнструмент из списка Automation tools, содержащий " +
                "наибольшее количество символов: " + maxSimbols);
    }


}
