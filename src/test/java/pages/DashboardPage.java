package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private final SelenideElement totalBalance = $("#total-balance");
    private final SelenideElement totalAccount = $("#summary-total-accounts");

    public String getTotalBalance() {
        Selenide.sleep(3000);
        return totalBalance.getText();
    }

    public String getTotalAccount() {
        return totalAccount.getText();
    }







}
