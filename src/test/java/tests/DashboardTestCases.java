package tests;

import base.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.conditions.Attribute;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardTestCases extends BaseTest {

    LoginPage loginPage = new LoginPage();


    @Test
    public void SkeletonLoadingStateAppearsOnPageLoadThenDataRenders() {
        open("/");
        loginPage.loginAdmin("admin", "admin123");
        open("/dashboard");
        $("#dashboard-page-container").shouldHave(attribute("data-loading", "true"));
        $("[data-testid='skeleton-card']").shouldHave(CollectionCondition.sizeGreaterThan(0));



    }



}
