package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.models.EditFileData;
import ru.itis.models.FileData;

import java.util.ArrayList;

public class EditFileTest extends TestBase {

        @Test
        public void editFileTest() {
            EditFileData file = new EditFileData("test.txt",
                    "lordvidex/selenium-test",
                    "",
                    "test2.txt",
                    "edited commit");
            app.getNavigation().openFileEditPage(file.getRepositoryName(), file.getName());
            app.getFile().editFile(file);

            // assertions
            FileData editedFile = FileData.builder().name(file.getNewFileName()).commit(file.getNewCommit()).repositoryName(file.getRepositoryName()).build();
            ArrayList<FileData> files = new ArrayList<>() {{
                add(editedFile);
            }};
            Assert.assertFalse(app.getFile().notFound(files));
        }
}
