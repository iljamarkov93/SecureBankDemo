package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Login extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void successfulLoginWithAdminCredentials() {

        open("/");
        loginPage.login("admin", "admin123");
        webdriver().shouldHave(url("https://qaplayground.com/bank/dashboard"));
        $("#main-content").shouldHave(text("Dashboard"));

    }
}