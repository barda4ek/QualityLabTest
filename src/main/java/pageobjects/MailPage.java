package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MailPage {
    protected WebDriver driver;

    public MailPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(css = ".compose-button__wrapper span")
    protected WebElement createLetterButton;

    @FindBy(css = ".ph-project-promo-close-icon__container")
    protected WebElement closePopUpButton;

    public void clickCreateLetterButton() {
        closePopUpButton.click();
        createLetterButton.click();
    }


}
