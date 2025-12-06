package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

public class NewLetterPage {

    protected WebDriver driver;

    public NewLetterPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".contactsContainer--3RMuQ .input--3slxg input")
    protected WebElement destinationAddress;

    @FindBy(css = ".compose-app.compose-app_fix .subject__wrapper--2mk6m input")
    protected WebElement themeField;

    private static final int RANDOM_KEY = 1000 + (int) (Math.random() * 9000);
    public static final String LETTER_THEME = "TestKey: " + RANDOM_KEY;

    @FindBy(css = "div[role=\"textbox\"] > div:nth-of-type(1)")
    protected WebElement messageField;

    @FindBy(css = "button[data-test-id=\"send\"]")
    protected WebElement sendButton;

    @FindBy(css = ".layer__link")
    protected WebElement letterSent;

    public void fillMessageBodyAndSend(String bodyText) {
        messageField.click();
        messageField.sendKeys(bodyText);
        sendButton.click();
    }

    public void fillTheme() {
        themeField.click();
        themeField.sendKeys(LETTER_THEME);
    }

    public void fillDestinationAddress(String destinationAddress) {
        this.destinationAddress.sendKeys(destinationAddress);
    }

    public void checkMessage() {
        assertEquals(letterSent.getText(), "Письмо отправлено");
    }

}
