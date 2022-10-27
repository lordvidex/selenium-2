package ru.itis.tests;

import org.junit.jupiter.api.Test;
import ru.itis.models.AccountData;
import ru.itis.models.RepositoryData;

public class RepoCreationTest extends TestBase {
    @Test
    public void repoCreationTest() throws InterruptedException {
        app.getNavigation().openLoginPage();
        System.out.println(System.getenv("GITHUB_PASSWORD"));
        AccountData account = new AccountData(System.getenv("GITHUB_USER"), System.getenv("GITHUB_PASSWORD"));
        app.getAuth().login(account);

        Thread.sleep(3000);
        app.getNavigation().openNewRepositoryPage();
        RepositoryData repo = new RepositoryData("selenium-test", "This is a Test Repo created by selenium", true, true);
        app.getRepository().createRepository(repo);
        Thread.sleep(10000);
    }
}
