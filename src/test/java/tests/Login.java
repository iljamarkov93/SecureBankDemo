package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Login extends BaseTest {

    @Test
    public void successfulLoginWithAdminCredentials() {

        open("/");
    }
}