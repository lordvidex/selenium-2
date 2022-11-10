package ru.itis.tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.models.FileData;

import java.io.IOException;
import java.io.InputStream;

public class CreateFileTest extends TestBase {
    private FileData file;
    @Before
    public void readFile() throws IOException  {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Test.class.getResourceAsStream("/file.json");
        file = mapper.readValue(is, FileData.class);
    }
    @Test
    public void createFileTest() throws InterruptedException {
//        String repositoryName = "lordvidex/selenium-test";
//        app.getNavigation().openRepositoryPage(repositoryName);
//        FileData newFile = FileData.builder().name("test.txt").repositoryName(repositoryName).build();
        FileData newFile = file;
//        newFile.setCommit("This is a test commit from selenium");
        app.getFile().createFile(newFile);

        Thread.sleep(2000);
        // assertions
        FileData createdFile = app.getFile().getCreatedFile(file.getRepositoryName());
        Assert.assertEquals(newFile.getName(), createdFile.getName());
        Assert.assertEquals(newFile.getCommit(), createdFile.getCommit());
    }
}
