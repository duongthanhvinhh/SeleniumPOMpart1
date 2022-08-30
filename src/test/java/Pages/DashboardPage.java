package Pages;

import Utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    private WebDriver driver;
    private ProjectPage projectPage;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        //new LogInPage(driver);
        new WebUI(driver);
        projectPage = new ProjectPage(driver);
    }
    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    private By logOutButton = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");
    public By menuMainPage = By.xpath("//a[normalize-space()='Trang chủ']");
    public ProjectPage openProject(){
        WebUI.clickElement(menuProject);
        boolean checkPage = WebUI.checkElementsExist(projectPage.projectHeaderPage);
        Assert.assertTrue(checkPage,"Failed to open Project Page");
        return new ProjectPage(driver);
    }
    public void openTasks(){
        WebUI.clickElement(menuTasks);
    }
    public void logOut(){
        WebUI.clickElement(logOutButton);
    }
}
