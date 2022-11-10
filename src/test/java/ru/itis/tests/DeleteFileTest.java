package ru.itis.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.AppManager;
import ru.itis.models.FileData;

import java.util.ArrayList;

public class DeleteFileTest extends TestBase {

    @Test
    public void deleteTestFiles() {
        ArrayList<FileData> files = new ArrayList<>();
        files.add(app.getData().getFile());
        files.add(app.getData().getEditedFile().toFile());
        app.getFile().deleteFiles(app.getData().getFile().getRepositoryName(), files);

        Assert.assertTrue(app.getFile().notFound(files));
    }

    @AfterClass
    public static void tearDown() {
        AppManager.getInstance().clean();
    }
}
