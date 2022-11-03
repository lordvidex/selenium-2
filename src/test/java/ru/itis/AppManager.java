package ru.itis;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.helpers.FileHelper;
import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.NavigationHelper;
import ru.itis.helpers.RepositoryHelper;

import static java.lang.ref.Cleaner.*;


@Getter
public class AppManager implements Cleanable {

    private static final ThreadLocal<AppManager> app = new ThreadLocal<>();
    private final String baseURL;
    private final WebDriver driver;
    private final StringBuilder verificationErrors;

    private final NavigationHelper navigation;
    private final LoginHelper auth;
    private final RepositoryHelper repository;

    private final FileHelper file;

    public static AppManager getInstance() {
        if (app.get() == null) {
            app.set(new AppManager());
        }
        return app.get();
    }
    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://github.com";
        verificationErrors = new StringBuilder();
        navigation = new NavigationHelper(this);
        auth = new LoginHelper(this);
        file = new FileHelper(this);
        repository = new RepositoryHelper(this);
    }

    @Override
    public void clean() {
        driver.quit();
    }
}
