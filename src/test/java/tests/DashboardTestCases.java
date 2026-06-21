package tests;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
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
        //Step1
        loginPage.loginAdmin("admin", "admin123");
        open("/dashboard");
        //Step2
        $("#dashboard-page-container").shouldHave(attribute("data-loading", "false"));
        //Step3
        double dashboardBalance = dashboard.getTotalBalance();
        int dashBoardAccount = dashboard.getAccountsCount();
        //Step4
        open("/accounts");
        $("#accounts-page-container").shouldHave(attribute("data-loading", "false")); //ожидание пока прогрузится страница
        double balanceSum = account.sumAllAccountBalances();
        int accountRows = account.getAccountRowsCount();
        Assertions.assertEquals(dashboardBalance, balanceSum);
        //Step5
        Assertions.assertEquals(dashBoardAccount, accountRows);




    }

}
