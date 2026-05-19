package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://qaplayground.com/bank";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        //Отключение менеджера паролей
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        Configuration.browserCapabilities = options;
    }

    @AfterEach
    void tearDown() {
        com.codeborne.selenide.Selenide.closeWebDriver();
    }
}