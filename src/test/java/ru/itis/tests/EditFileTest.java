package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.EditFileData;
import ru.itis.models.FileData;

import java.util.ArrayList;

public class EditFileTest extends TestBase {

    @Test
    public void editFileTest() {
        // get the original file and the new edit data
        FileData originalFile = app.getData().getFile();
        EditFileData file = app.getData().getEditedFile();

        // set the old information of the file with originalFile data in case of data mismatch
        file.setName(originalFile.getName());
        file.setCommit(originalFile.getCommit());
        file.setRepositoryName(originalFile.getRepositoryName());
        app.getNavigation().openFileEditPage(file.getRepositoryName(), file.getName());
        app.getFile().editFile(file);

        // assertions
        FileData editedFile = FileData.builder()
                .name(file.getNewFileName())
                .commit(file.getNewCommit())
                .repositoryName(file.getRepositoryName())
                .build();
        ArrayList<FileData> files = new ArrayList<>() {{
            add(editedFile);
        }};
        Assert.assertFalse(app.getFile().notFound(files));
    }
}
