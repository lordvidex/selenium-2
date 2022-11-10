package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.AccountData;
import ru.itis.models.RepositoryData;

public class CreateRepoTest extends TestBase {
    @Test
    public void repoCreationTest() throws InterruptedException {
        app.getNavigation().openNewRepositoryPage();
        RepositoryData repo = new RepositoryData("selenium-test", "This is a Test Repo created by selenium", true, true);
        app.getRepository().createRepository(repo);
        Thread.sleep(5000);
        // assertions
        RepositoryData createdRepo = app.getRepository().getCreatedRepository();
        Assert.assertEquals(repo.getName(), createdRepo.getName());
    }
}
