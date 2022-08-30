package TestCases;

import Common.BaseTest;
import Pages.DashboardPage;
import Pages.LogInPage;
import Utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LogInPage logInPage;
    private DashboardPage dashboardPage;
    @BeforeMethod
    public void setupTest(){
        logInPage = new LogInPage(driver);
        //dashboardPage = new DashboardPage(driver);
        new WebUI(driver);
    }

    @Test
    public void logOutTest(){
        dashboardPage = logInPage.LogIn("https://hrm.anhtester.com","admin01","123456");
        dashboardPage.logOut();
    }

    @Test
    public void openProject(){
        dashboardPage = logInPage.LogIn("https://hrm.anhtester.com","admin01","123456");
        dashboardPage.openProject();
    }
}
