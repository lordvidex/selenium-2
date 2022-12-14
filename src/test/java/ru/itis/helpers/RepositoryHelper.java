package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.AppManager;
import ru.itis.models.RepositoryData;

public class RepositoryHelper extends HelperBase {
    public RepositoryHelper(AppManager manager) {
        super(manager);
    }

    public void createRepository(RepositoryData data) {
        fillFieldById(data.getName(), "repository_name");
        fillFieldById(data.getDescription(), "repository_description");
        if (data.isPrivate()) {
            clickItemById("repository_visibility_private");
        }
        if (data.isHasReadMe()) {
            clickItemById("repository_auto_init");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        driver.findElement(By.className("btn-primary")).click();
    }
}
