package ru.itis.tests;

import org.junit.jupiter.api.*;
import ru.itis.AppManager;

public class TestBase {
    protected AppManager app;

    @BeforeEach
    public void setupTest() {
       app = new AppManager();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
        Assertions.assertEquals("", app.getVerificationErrors().toString());
    }
}
