package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//select[@id=\"id_queue\"]")
    private WebElement queueList;

    @FindBy(xpath = "//option[text()=\"Billing Queries\"]")
    private  WebElement queue1;

    @FindBy(xpath = "//input[@id=\"id_title\"]")
    private  WebElement titleField;

    @FindBy(xpath = "//textarea[@id=\"id_body\"]")
    private  WebElement bodyField;

    @FindBy(xpath = "//input[@id=\"id_due_date\"]")
    private WebElement dateField;

    @FindBy(xpath = "//table[@class=\"ui-datepicker-calendar\"]//a[text()='22']")
    private WebElement chooseDate;

    @FindBy(xpath = "//input[@id=\"id_submitter_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private  WebElement submitButton;

    @FindBy(xpath = "//a[@id=\"userDropdown\"]")
    private WebElement logInButton;

    public MainPage() {
        driver.get("https://django-helpdesk-demo.herokuapp.com/");
        PageFactory.initElements(driver, this);
    }

    public MainPage createTicket(String titleValue, String bodyValue, String emailValue) {
        queueList.click();
        queue1.click();
        titleField.sendKeys(titleValue);
        bodyField.sendKeys(bodyValue);
        dateField.click();
        chooseDate.click();
        emailField.sendKeys(emailValue);
        submitButton.click();
        return this;
    }

    public LoginPage goToLoginPage(){
        logInButton.click();
        return new LoginPage();
    }
}
