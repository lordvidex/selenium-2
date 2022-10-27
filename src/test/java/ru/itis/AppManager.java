package ru.itis;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.NavigationHelper;
import ru.itis.helpers.RepositoryHelper;

@Getter
public class AppManager {
    private final String baseURL;
    private final WebDriver driver;
    private final StringBuilder verificationErrors;

    private final NavigationHelper navigation;
    private final LoginHelper auth;
    private final RepositoryHelper repository;

    public AppManager() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://github.com";
        verificationErrors = new StringBuilder();
        navigation = new NavigationHelper(this);
        auth = new LoginHelper(this);
        repository = new RepositoryHelper(this);
    }

    public void stop() {
        driver.quit();
    }
}
