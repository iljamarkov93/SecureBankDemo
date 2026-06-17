package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private final SelenideElement totalBalance = $("#summary-total-balance");
    private final SelenideElement totalAccount = $("#summary-total-accounts");


    public String sumTotalBalance() {
        return totalBalance.getText();
    }

    public String getTotalAccount() {
        return totalAccount.getText();
    }


}
