package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.RepositoryData;


public class CreateRepoTest extends TestBase {
    @Test
    public void repoCreationTest() throws InterruptedException {
        RepositoryData repo = app.getData().getRepo();
        app.getNavigation().openNewRepositoryPage();
        app.getRepository().createRepository(repo);
        Thread.sleep(5000);
        // assertions
        RepositoryData createdRepo = app.getRepository().getCreatedRepository();
        Assert.assertEquals(repo.getName(), "lordvidex/" + createdRepo.getName());
    }
}
