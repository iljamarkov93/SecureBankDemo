package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private final SelenideElement totalBalance = $("#total-balance");
    private final SelenideElement totalAccount = $("#accounts-count");

    public double getTotalBalance() {
        Selenide.sleep(3000);
        String text = totalBalance.getText();

        return Double.parseDouble(
                text.replace("$", "")
                        .replace(",", ""));
    }


    public int getAccountsCount() {
        return Integer.parseInt(totalAccount.getText().trim());
}


}
