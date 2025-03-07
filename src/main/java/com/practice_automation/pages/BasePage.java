package com.practice_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    protected static WebDriver driver;
    public String browser;
    public String baseUrl;
    public Properties properties;
    protected String inputText = "Сергей";
    protected String inputPassword = "TestPassword_12345&";

    private void loadProperties() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("G:\\GitHub\\SimbirSoftTask\\src\\main\\java\\com\\practice_automation\\config\\config.properties");
            properties.load(fis);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void openBrowser() {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public  void  closeBrowser() {
        driver.quit();
    }
    public Boolean goToBasePage() {
        try {
          loadProperties();
          openBrowser();
          driver.get(baseUrl);
        } catch (Exception ex) {
            System.out.println("Невозможно перейти к базовой странице");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
