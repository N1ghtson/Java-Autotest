package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseSeleniumPage {

    @FindBy(id = "search_query")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class=\"tickettitle\"]")
    private WebElement ticket;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public TicketPage findTicket(String str){
        searchField.sendKeys(str, Keys.ENTER);
        ticket.click();
        return new TicketPage();
    }
}
