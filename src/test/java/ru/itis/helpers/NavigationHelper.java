package ru.itis.helpers;

import ru.itis.AppManager;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(AppManager manager) {
        super(manager);
    }

    public void openLoginPage() {
        driver.navigate().to(manager.getBaseURL() + "/login");
    }

    public void openNewRepositoryPage() {
        driver.navigate().to(manager.getBaseURL() + "/new");
    }
}
