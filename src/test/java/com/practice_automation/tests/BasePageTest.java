package com.practice_automation.tests;

import com.practice_automation.pages.FieldsAndForms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasePageTest extends BaseTest {
    FieldsAndForms forms = new FieldsAndForms();

    @Test
    public void testBasePage() {
        String pageTitle = forms.getPageTitle();
        Assert.assertEquals(pageTitle, "Form Fields | Practice Automation");
    }

    @Test(priority = 1, description = "Заполнение поля Name")
    public void testInputNameField() {
        String displayedText = forms.getAssertInputName();
        Assert.assertEquals(displayedText, inputText, "Введенное и отображаемое имена не совпадают");
    }

    @Test(priority = 2, description = "Заполнение поля Password")
    public void testInputPasswordField() {
        String enteredPassword = forms.getAssertInputPassword();
        Assert.assertEquals(enteredPassword, inputPassword, "Введенный пароль неверен");
    }

    @Test(priority = 3, description = "Выбор Milk checkbox")
    public void testInputCheckBoxMilk() {
        WebElement checkboxMilk = forms.clickCheckBoxMilkAndCheckCondition();
        boolean MilkisSelected = checkboxMilk.isSelected();
        Assert.assertTrue(MilkisSelected, "Checkbox Milk не был выбран после нажатия");
    }

    @Test(priority = 4, description = "Выбор Coffee checkbox")
    public void testSelectCheckBoxCoffee() {
        WebElement checkboxCoffee = forms.clickCheckBoxCoffeeAndCheckCondition();
        checkboxCoffee.click();
        boolean CoffeeisSelected = checkboxCoffee.isSelected();
        Assert.assertTrue(CoffeeisSelected, "Checkbox Coffee не был выбран после нажатия");
    }

    @Test(priority = 5, description = "Выбор radiobutton")
    public void testSelectRadiobutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement radiobutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Yellow']")));
        radiobutton.click();
        boolean isSelected = radiobutton.isSelected();
        Assert.assertTrue(isSelected, "Radiobutton не была выбрана после нажатия");
    }

    @Test(priority = 6, description = "Выбор элемента выпадающего меню")
    public void testDropDownMenu() {
        WebElement dropDownMenu = driver.findElement(By.id("automation"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Yes");
    }

    @Test(priority = 7, description = "Заполнения поля email")
    public void testFillingEmailField() {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("sergey.vyshkvarok@gmail.com");
    }

    @Test(priority = 8, description = "Заполнение поля Message")
    public void testFillingMessageField() {
        WebElement ulElement = driver.findElement(By.xpath("//form/ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        int count = liElements.size();
        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='message']"));

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

    @Test
    public void testPressingSubmitButton() {
        WebElement SubmitButton = driver.findElement(By.id("submit-btn"));
        SubmitButton.click();
    }

}
