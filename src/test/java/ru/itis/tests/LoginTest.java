package ru.itis.tests;

import org.junit.jupiter.api.Test;
import ru.itis.models.AccountData;

public class LoginTest extends TestBase {
    @Test
    public void loginTest() {
        app.getNavigation().openLoginPage();
        AccountData data = new AccountData(System.getenv("GITHUB_USER"),System.getenv("GITHUB_PASSWORD") );
        app.getAuth().login(data);
    }
}
