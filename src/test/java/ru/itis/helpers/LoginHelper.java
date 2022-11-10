package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.models.AccountData;
import ru.itis.AppManager;

import java.util.Arrays;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(AccountData account) {
        fillFieldByName(account.getUsername(), "login");
        fillFieldByName(account.getPassword(), "password");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.tagName("body")).getAttribute("class").contains("logged-in");
    }

}
