package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.AppManager;

public class HelperBase {
    protected WebDriver driver;
    protected AppManager manager;
    HelperBase(AppManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    protected void clickItemById(String id) {
        driver.findElement(By.id(id)).click();
    }

    protected void fillFieldById(String value, String id) {
        driver.findElement(By.id(id)).clear();

        driver.findElement(By.id(id)).sendKeys(value);
    }

    protected void fillFieldByName(String value, String fieldName) {
        driver.findElement(By.name(fieldName)).clear();

        driver.findElement(By.name(fieldName)).sendKeys(value);
    }
}
