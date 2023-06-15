package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageobjects.BasePage;
import pageobjects.MailPage;
import pageobjects.NewLetterPage;
import pageobjects.SentLettersPage;


public class QualityLabCucumber extends QualityLabCucumberRunner {

    // BasePage basePage;
    protected NewLetterPage newLetterPage;
    protected MailPage mailPage;
    protected SentLettersPage sentLettersPage;

    @Given("I am on the Mail.ru Page")
    public void iAmOnTheBasePage(){
        basePage = new BasePage(driver);
        basePage.go();
    }

    @When("^I login to my account as ([^\"]*)@mail.ru with password ([^\"]*)")
    public void iLoginToMyAccount(String account, String password) {
        basePage.fillLoginModal(account, password);
    }

    @And("I click Compose new letter")
    public void iClickComposeNewLetter(){
        mailPage = new MailPage(driver);
        mailPage.createLetterButtonClick();
    }

    @And("I fill theme with randomKey")
    public void iFillThemeWithRandomCode(){
        newLetterPage = new NewLetterPage(driver);
        newLetterPage.fillTheme();
    }

    //chvvplrzmbutmfzfzj@tmmcv.com
    @And("^I fill destination address: ([^\"]*)$")
    public void iFillDestination(String query){
        newLetterPage.fillDestinationAddress(query);
    }

    @And("I fill message body and send.")
    public void iFillMessageBody(){
        newLetterPage.fillMessageBodyAndSend("Добрый день! Меня зовут Красильников Евгений, я матёрый IT-специалист");
    }

    @Then("I check message \"Сообщение отправлено\"")
    public void iCheckMessage(){
        newLetterPage.checkMessage();
    }

    @And("I check if the last sent letter's theme is equal to Expected")
    public void iAmOnTheHouseAndGardenPage(){
        sentLettersPage = new SentLettersPage(driver);
        sentLettersPage.checkLastLetterTheme(NewLetterPage.letterTheme);
    }



}
