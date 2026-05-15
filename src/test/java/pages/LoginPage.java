package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInput = $("#username");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $("#login-btn");
    private SelenideElement clearButton = $("#clear-btn");


    public void login(String username, String password) {

        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

}
