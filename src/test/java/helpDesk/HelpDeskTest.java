package helpDesk;

import core.BaseSeleniumTest;
import helpers.TestValues;
import org.junit.Assert;
import org.junit.Test;


import static helpers.StringHelpers.getUniqueString;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void checkTicket() {
        String title = getUniqueString(TestValues.TEST_TITLE);
        TicketPage ticketPage = new MainPage().createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .goToLoginPage()
                .auth("demo", "demo1234")
                .findTicket(title);

        Assert.assertTrue(ticketPage.getTitle().contains(title));
        Assert.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
        Assert.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);

    }
}
