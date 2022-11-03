package ru.itis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.itis.tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        CreateRepoTest.class,
        CreateFileTest.class,
        EditFileTest.class,
        DeleteFileTest.class,
})
public class TestSuite {
}
