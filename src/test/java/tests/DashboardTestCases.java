package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.DashboardPage;
import pages.LoginPage;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardTestCases extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboard = new DashboardPage();
    AccountPage account = new AccountPage();


    @Test
    public void SkeletonLoadingStateAppearsOnPageLoadThenDataRenders() {

        open("/");
        loginPage.loginAdmin("admin", "admin123");
        open("/dashboard");
        $("#dashboard-page-container").shouldHave(attribute("data-loading", "true"));
        $$("[data-testid='skeleton-card']").forEach(card -> card.shouldBe(visible));
        $("#dashboard-page-container").shouldHave(attribute("data-loading", "false"), Duration.ofSeconds(2));
        $("#total-balance-card").shouldHave(visible).shouldHave(text("$"));
        $("[data-testid='accounts-count']").shouldBe(visible);
        $("#accounts-count").shouldHave(matchText("\\d+"));
        $("[data-testid='transactions-count-card']").shouldBe(visible);
        $("#transactions-count").shouldHave(matchText("\\d+"));

    }


    @Test
    public void StatCardValuesMatchActualAccountAndTransactionData() {
        open("/");
        loginPage.loginAdmin("admin", "admin123");
        open("/dashboard");
        $("#dashboard-page-container").shouldHave(attribute("data-loading", "false"));
        //System.out.println(dashboard.getTotalBalance());
        open("/accounts");
        $$("[data-testid='account-balance']")
                .forEach(el -> System.out.println(el.getText()));

        /*Остановился на том что надо суммировать со страницы /account значения и сравнить их с суммой на /dashboard
        Проблема сейчас в том что я не могу получить суммы со страницы /account*/



    }

}
