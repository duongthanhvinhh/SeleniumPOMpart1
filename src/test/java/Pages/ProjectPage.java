package Pages;

import Utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    WebDriver driver;
    public ProjectPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    public By projectHeaderPage = By.xpath("//li[@class='nav-item active']//a[@class='mb-3 nav-link']");
    By addNew_btn = By.xpath("//a[normalize-space()='Thêm mới']");
    By title_textBox = By.xpath("//input[@placeholder='Tiêu đề']");
    By consumer_dropdown = By.id("select2-client_id-container");
    By consumer_input = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
    By startDate_textBox = By.xpath("//input[@placeholder='Ngày bắt đầu']");
    By selectStartDate17 = By.xpath("//a[normalize-space()='17']");
    By startDateOK_button = By.xpath("//button[normalize-space()='OK']");
    By endDate_textBox = By.xpath("//input[@placeholder='Ngày kết thúc']");
    By selectEndDate25 = By.xpath("(//a[contains(text(),'25')])[2]");
    By endDateOK_button = By.xpath("(//button[normalize-space()='OK'])[2]");

    By summary_textBox = By.xpath("//textarea[@id='summary']");
    By save_btn = By.xpath("//span[contains(text(),'Lưu')]");
    public void clickAddNewButton(){
        WebUI.clickElement(addNew_btn);
    }

    public void enterRequiredData(){
        WebUI.setTexts(title_textBox,"A project");
        WebUI.clickElement(consumer_dropdown);
        WebUI.setTexts(consumer_input,"Huong Nguyen\n");
        WebUI.clickElement(startDate_textBox);
        WebUI.clickElement(selectStartDate17);
        WebUI.clickElement(startDateOK_button);
        WebUI.clickElement(endDate_textBox);
        WebUI.clickElement(selectEndDate25);
        WebUI.clickElement(endDateOK_button);
        WebUI.setTexts(summary_textBox,"My notes");
        WebUI.clickElement(save_btn);

    }

    public void addNewProject(){
        clickAddNewButton();
        enterRequiredData();
    }
}
