package tests;

import base.BaseTest;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginPageTestCases extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void SuccessfulLoginWithAdminCredentials() {

        open("/");
        loginPage.loginAdmin("admin", "admin123");
        webdriver().shouldHave(url("https://qaplayground.com/bank/dashboard"));
        $("#main-content").shouldHave(text("Dashboard"));

    }

    @Test
    public void FailedLoginShowsErrorAlertForInvalidCredentials() {
        open("/");
        loginPage.loginAdmin("wrong", "wrong123");
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

    @Test
    public void PressingEnterInThePasswordFieldSubmitsTheLoginForm() {
        open("/");
        $("#username").type("admin");
        $("#password").type("admin123").pressEnter();
        $("#main-content").shouldHave(text("Dashboard"));

    }

    @Test
    public void ReadOnlyViewerLoginGrantsRestrictedAccess() {
        open("/");
        loginPage.loginViewer("viewer", "viewer123");
        webdriver().shouldHave(urlContaining("/dashboard"));
        $("#viewer-badge").shouldBe(visible).shouldHave(text("Read-only"));
        $("[data-testid='role-indicator']").shouldHave(text("Read-only Viewer"));
        $("#nav-accounts").click();
        $(byText("Add New Account")).shouldNot(exist);


    }



}