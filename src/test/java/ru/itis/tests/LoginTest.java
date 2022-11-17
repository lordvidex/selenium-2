package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.AccountData;

public class LoginTest extends TestBase {
    @Test
    public void loginWithValidData() {
        app.getNavigation().openLoginPage();
        AccountData data = new AccountData(System.getenv("GITHUB_USER"),System.getenv("GITHUB_PASSWORD") );
        app.getAuth().login(data);
        Assert.assertTrue(app.getAuth().isLoggedIn());
    }

    @Test
    public void loginWithInvalidData() {
        app.getNavigation().openLoginPage();
        AccountData data = new AccountData("invalid", "invalid");
        app.getAuth().login(data);
        Assert.assertFalse(app.getAuth().isLoggedIn());
    }
}
