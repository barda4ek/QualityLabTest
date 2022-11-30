package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginModal {

    @FindBy(css = "input[name='username']")
    private WebElement loginInput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-test-id=next-button]")
    protected WebElement enterPasswordButton;
    private WebDriver driver;

    public LoginModal(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void fillModal(String login, String password) {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
        loginInput.sendKeys(login);
        enterPasswordButton.click();
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }
}
