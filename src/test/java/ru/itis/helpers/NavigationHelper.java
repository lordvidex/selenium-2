package ru.itis.helpers;

import ru.itis.AppManager;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(AppManager manager) {
        super(manager);
    }

    public void openLoginPage() {
        goTo(manager.getBaseURL() + "/login");
    }

    public void openNewRepositoryPage() {
        goTo(manager.getBaseURL() + "/new");
    }

    public void openRepositoryPage(String repositoryName) {
        goTo(manager.getBaseURL() + "/" + repositoryName);
    }

    public void openFilePage(String repositoryName, String fileName) {
        goTo(manager.getBaseURL() + "/" + repositoryName + "/blob/master/" + fileName);
    }

    public void openFileEditPage(String repositoryName, String fileName) {
        goTo(manager.getBaseURL() + "/" + repositoryName + "/edit/master/" + fileName);
    }

    public void goTo(String url) {
        driver.navigate().to(url);
    }
}
