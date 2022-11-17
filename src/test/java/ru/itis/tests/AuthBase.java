package ru.itis.tests;

import org.junit.Before;
import ru.itis.AppManager;
import ru.itis.models.AccountData;

public class AuthBase {
    protected AppManager app;
    @Before
    public void setUp() {
        app = AppManager.getInstance();
        if (!app.getAuth().isLoggedIn()) {
            app.getAuth().login(
                    new AccountData(
                            System.getenv("GITHUB_USER"),
                            System.getenv("GITHUB_PASSWORD")
                    )
            );
        }
    }
}
