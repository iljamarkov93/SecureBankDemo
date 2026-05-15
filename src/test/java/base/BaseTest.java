package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;

public class BaseTest {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://qaplayground.com/bank";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @AfterEach
    void tearDown() {
        com.codeborne.selenide.Selenide.closeWebDriver();
    }
}