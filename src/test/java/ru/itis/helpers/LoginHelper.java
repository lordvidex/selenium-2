package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        try {
            return driver.findElement(By.tagName("body")).getAttribute("class").contains("logged-in");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        // details -> summary -> span
        WebElement details;
        try {
            details = driver.findElement(By.id("details-10bb54"));
            if (details == null) {
                return false;
            }
            return details.findElement(By.cssSelector("span.css-truncate-target")).getText().equals(username);
        } catch (Exception e) {
            return false;
        }
    }

}
