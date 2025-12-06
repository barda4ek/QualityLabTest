package selenium;

import org.testng.annotations.*;
import pageobjects.BasePage;
import pageobjects.MailPage;
import pageobjects.NewLetterPage;
import pageobjects.SentLettersPage;

public class LoginTest extends BaseTest {
    private BasePage basePage;
    private NewLetterPage newLetterPage;
    private MailPage mailPage;
    private SentLettersPage sentLettersPage;

    @BeforeMethod
    void beforeMethod() {
        basePage = new BasePage(driver);
        newLetterPage = new NewLetterPage(driver);
        mailPage = new MailPage(driver);
        sentLettersPage = new SentLettersPage(driver);
    }

    @Test
    public void loginTest()  {
        basePage.go();
        basePage.fillLoginModal("testuser", "testpassword");
        mailPage.clickCreateLetterButton();
        newLetterPage.fillTheme();
        newLetterPage.fillDestinationAddress("chvvplrzmbutmfzfzj@tmmcv.com");
        newLetterPage.fillMessageBodyAndSend("Hello! This is a test message from an automated test.");
        newLetterPage.checkMessage();
        sentLettersPage.checkLastLetterTheme(NewLetterPage.LETTER_THEME);
    }

}
