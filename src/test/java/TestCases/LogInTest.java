package TestCases;

import Common.BaseTest;
import Pages.LogInPage;
import Utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    private LogInPage loginPage; // khoi tao doi tuong cho SignInpage

    //    Ham xay dung (luon luon chay dau tien, truoc het tat ca. Trong th nay, neu xai ham xay dung thi no se bao null driver. Vi ham xay dung chay truoc BaseTest, nen null)
//    public LogInTest(){
//        loginPage = new LogInPage(driver);
//    }
    @BeforeMethod
     void setupTest() {
        loginPage = new LogInPage(driver);
        new WebUI(driver);
    }

    @Test
    public void TC01_testSignIn_Valid() {
        //loginPage = new LogInPage(driver); // truyen driver tu BastTest sang cac class Page
        loginPage.LogIn("https://hrm.anhtester.com", "admin01", "123456");
    }

    @Test
    public void TC02_testSignIn_Valid() {
        //loginPage = new LogInPage(driver); // truyen driver tu BastTest sang cac class Page
        loginPage.LogIn("https://hrm.anhtester.com", "client01", "123456");
    }

    @Test
    public void TC03_testSignIn_Valid() {
        //loginPage = new LogInPage(driver); // truyen driver tu BastTest sang cac class Page
        loginPage.LogIn("https://hrm.anhtester.com", "leader01", "123456");
    }

    @Test
    public void TC04_testForgotPassword(){
        loginPage.resetPassword("https://hrm.anhtester.com","client01@mailinator.com");
    }

    @Test
    public void TC05_testSignIn_InvalidUsername(){
        loginPage.LogInInvalidUsername("https://hrm.anhtester.com","invalidUser","123456");
        //Xu li them assert trong method LogInInvalidEmail
    }

    @Test
    public void TC06_testSignIn_InvalidPassword(){
        loginPage.LogInInvalidPassword("https://hrm.anhtester.com","client01","");
        //Xu li them assert trong method LogInInvalidEmail
    }

}
