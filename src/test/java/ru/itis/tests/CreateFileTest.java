package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.FileData;

import java.util.Collections;

public class CreateFileTest extends TestBase {
    @Test
    public void createFileTest() throws InterruptedException {
        FileData newFile = app.getData().getFile();
        app.getFile().createFile(newFile);

        Thread.sleep(2000);
        // assertions
        Assert.assertFalse(app.getFile().notFound(Collections.singleton(newFile)));
    }
}
