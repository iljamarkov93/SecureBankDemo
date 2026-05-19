package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInput = $("#username");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $("#login-btn");
    private SelenideElement clearButton = $("#clear-btn");
    private SelenideElement togglePasswodVisibility = $("#toggle-password");



    public void loginAdmin(String username, String password) {

        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    public void loginViewer(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }



    public void togglePasswodVisibility() {

        togglePasswodVisibility.click();
    }

}
