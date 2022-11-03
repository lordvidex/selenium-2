package ru.itis.tests;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.FileData;

public class CreateFileTest extends TestBase {
    @Test
    public void createFileTest() throws InterruptedException {
        String repositoryName = "lordvidex/selenium-test";
        app.getNavigation().openRepositoryPage(repositoryName);
        FileData newFile = FileData.builder().name("test.txt").repositoryName(repositoryName).build();
        newFile.setCommit("This is a test commit from selenium");
        app.getFile().createFile(newFile);

        Thread.sleep(2000);
        // assertions
        FileData createdFile = app.getFile().getCreatedFile(repositoryName);
        Assert.assertEquals(newFile.getName(), createdFile.getName());
        Assert.assertEquals(newFile.getCommit(), createdFile.getCommit());
    }
}
