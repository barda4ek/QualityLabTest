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
        basePage.fillLoginModal("krasilnikovqualitylab", "quality1395");
        mailPage.createLetterButtonClick();
        //заполняю поле "тема", используя рандомное четырёхзначное число для последующей проверки совпадения
        newLetterPage.fillTheme();
        newLetterPage.fillDestinationAddress("chvvplrzmbutmfzfzj@tmmcv.com");
        newLetterPage.fillMessageBodyAndSend("Добрый день! Меня зовут Красильников Евгений, я матёрый IT-специалист");
        //проверяю наличие сообщения "Письмо отправлено"
        newLetterPage.checkMessage();
        //Проверяем, что тема последнего отправленного сообщения совпадает с нашим ключём
        sentLettersPage.checkLastLetterTheme(NewLetterPage.letterTheme);
    }

}
