package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPageTestCases extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void SuccessfulLoginWithAdminCredentials() {

        open("/");
        loginPage.login("admin", "admin123");
        webdriver().shouldHave(url("https://qaplayground.com/bank/dashboard"));
        $("#main-content").shouldHave(text("Dashboard"));

    }

    @Test
    public void FailedLoginShowsErrorAlertForInvalidCredentials() {
        open("/");
        loginPage.login("wrong", "wrong123");
        $("[data-testid='login-alert']").shouldBe(visible);
        $("#alert-message").shouldHave(text("Invalid username or password. Please try again."));
        webdriver().shouldHave(url("https://qaplayground.com/bank"));
    }

    @Test
    public void TogglePasswodVisibilityHidesAndRevealsPasswodText() {
        open("/");
        $("#password").type("password");
        $("#password").shouldHave(attribute("type", "password"));
        loginPage.togglePasswodVisibility();
        $("#password").shouldHave(attribute("type", "text"));
        loginPage.togglePasswodVisibility();
        $("#password").shouldHave(attribute("type", "password"));

    }
}