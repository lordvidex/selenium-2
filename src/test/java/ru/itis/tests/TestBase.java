package ru.itis.tests;

import org.junit.Before;
import ru.itis.AppManager;

public class TestBase {
    protected AppManager app;

    @Before
    public void setupTest() {
       app = AppManager.getInstance();
    }

}
