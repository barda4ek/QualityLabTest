package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    private WebDriver driver;
    private LoginModal loginModal;

    public void fillLoginModal(String login, String password) {
        closePopUp();
        clickLoginButton();
        loginModal.fillModal(login, password);
    }
    private static final String URL = "https://mail.ru/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
        this.loginModal = new LoginModal(driver);
    }

    public void go() {
        driver.get(URL);
    }

    @FindBy(css = "#mailbox > div.logged-out-one-click.svelte-giypkm > button")
    protected WebElement loginButton;
    public void closePopUp() {
        driver.findElement(By.linkText("Отклонить")).click();
    }
    public void clickLoginButton() {
        loginButton.click();
    }

}
