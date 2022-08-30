package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.WebUI;

import java.time.Duration;

public class LogInPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private DashboardPage dashboardPage;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khoi tao gia tri cho class WebUI
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dashboardPage = new DashboardPage(driver);
    }

    //LogIn
    private String pageText = "Welcome to HRM system";
    private By inputUsername = By.id("iusername");
    private By inputPassword = By.id("ipassword");
    private By buttonSignIn = By.className("ladda-label");


    //Forgot Password
    private By linkForgotPassword = By.xpath("//span[normalize-space()='Forgot password?']");
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.className("ladda-label");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessage = By.xpath("//div[@class='toast-message']");

    public DashboardPage LogIn(String URL, String Username, String password) {
        WebUI.navigateToURL(URL);
        WebUI.waitForElementVisible(inputUsername,10);
        WebUI.setTexts(inputUsername, Username);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        //wait.until(ExpectedConditions.presenceOfElementLocated(dashboardPage.menuMainPage));
        //wait for page loaded
        boolean checkMenu = WebUI.checkElementsExist(dashboardPage.menuMainPage);// check if Main menu exists or not
        Assert.assertTrue(checkMenu, "LogIn failed: Menu of main Page Not Found");

        return new DashboardPage(driver);
    }

    public void LogInInvalidUsername(String URL, String Username, String password) {
        String errorMessage = "";
        WebUI.navigateToURL(URL);
        WebUI.setTexts(inputUsername, Username);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        //Add assert
        if (Username.length() == 0) {
            errorMessage = "The username field is required.";
        } else {
            errorMessage = "Invalid Login Credentials.";
        }
        boolean checkAlertError = WebUI.checkElementsExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Failed: Error alert Not displayed");
        Assert.assertEquals(WebUI.getElementTexts(alertMessage), errorMessage, "Text did not match expectation");
    }

    public void LogInInvalidPassword(String URL, String Username, String password) {
        String errorMessage = "";
        WebUI.navigateToURL(URL);
        WebUI.setTexts(inputUsername, Username);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        //Add assert
        if (password.length() == 0) {
            errorMessage = "The password field is required.";
        } else if (password.length() < 6 || password.length() > 0) {
            errorMessage = "Your password is too short, minimum 6 characters required.";
        } else {
            errorMessage = "Invalid Login Credentials.";
        }
        boolean checkAlertError = WebUI.checkElementsExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Failed: Error alert Not displayed");
        Assert.assertEquals(WebUI.getElementTexts(alertMessage), errorMessage, "Text did not match expectation");
    }

    public void resetPassword(String URL, String emailForgot) {
        WebUI.navigateToURL(URL);
        WebUI.clickElement(linkForgotPassword);
        Assert.assertEquals(WebUI.getElementTexts(pageTextForgotPassword), "Reset your password");
        WebUI.setTexts(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);
        Assert.assertEquals(WebUI.getElementTexts(alertMessage), "Main.xin_error_msg__available");
        WebUI.clickElement(linkClickHere);
    }


}
