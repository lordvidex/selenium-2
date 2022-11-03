package ru.itis.tests;

import org.junit.Test;
import ru.itis.models.EditFileData;

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
        }
}
