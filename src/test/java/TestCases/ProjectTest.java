package TestCases;

import Common.BaseTest;
import Pages.DashboardPage;
import Pages.LogInPage;
import Pages.ProjectPage;
import Utils.WebUI;import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ProjectTest extends BaseTest{
    //private WebDriver driver; Nen nho la trong Test chi dung dung 1 cai driver cua BaseTest thoi. ko khai bao driver cho nay
    private LogInPage logInPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;
    @BeforeMethod
    public void setUpTest() {
        logInPage = new LogInPage(driver);
        new WebUI(driver);
    }

    @Test
    void TestOpenProject() {
        dashboardPage = logInPage.LogIn("https://hrm.anhtester.com", "admin01", "123456");
        dashboardPage.openProject();
    }
    @Test
    void addNewProject(){
        dashboardPage = logInPage.LogIn("https://hrm.anhtester.com","admin01","123456");
        projectPage = dashboardPage.openProject();
        projectPage.addNewProject();
    }
}
