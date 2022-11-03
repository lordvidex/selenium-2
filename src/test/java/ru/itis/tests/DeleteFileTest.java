package ru.itis.tests;

import org.junit.Test;
import ru.itis.models.FileData;

import java.util.ArrayList;
import java.util.Collection;

public class DeleteFileTest extends TestBase {
    @Test
    public void deleteTestFiles() {
        Collection<FileData> testFiles = new ArrayList<>() {{
            add(FileData.builder()
                    .commit("delete test1")
                    .name("test1.txt")
                    .repositoryName("lordvidex/selenium-test")
                    .build());
            add(FileData.builder()
                    .name("test2.txt")
                    .repositoryName("lordvidex/selenium-test")
                    .build()
            );
        }};
        app.getFile().deleteFiles(testFiles);
    }
}
