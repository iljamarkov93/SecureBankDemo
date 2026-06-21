package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AccountPage {

    private final SelenideElement totalBalance = $("#summary-total-balance");
    private final SelenideElement totalAccount = $("#summary-total-accounts");
    private final ElementsCollection accountRows = $$("[data-testid='account-balance']");


    public String sumTotalBalance() {

        return totalBalance.getText();
    }

    public String getTotalAccount() {

        return totalAccount.getText();
    }

    public int getAccountRowsCount() {
        return accountRows.size();
    }

    public double sumAllAccountBalances() {

        double sum = 0;

        for (var el : $$("[data-testid='account-balance']")) {

            String text = el.getText();

            double value = Double.parseDouble(
                    text.replace("$", "")
                            .replace(",", "")
            );

            sum += value;
        }

        return sum;
    }


}
