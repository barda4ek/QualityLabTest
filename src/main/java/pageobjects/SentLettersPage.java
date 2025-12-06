package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SentLettersPage {
    protected WebDriver driver;
    private static final String URL = "https://e.mail.ru/sent/";

    public SentLettersPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public void go() {
        driver.get(URL);
    }

    @FindBy(css = "div[role=\"rowgroup\"] > a:nth-of-type(1) .llc__subject")
    protected WebElement lastSentMessage;

    public void checkLastLetterTheme(String expectedTheme) {
        go();
        String actualTheme = lastSentMessage.getText();
        assertEquals(actualTheme, expectedTheme);
    }

}
