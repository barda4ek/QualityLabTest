package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageobjects.BasePage;
import pageobjects.MailPage;
import pageobjects.NewLetterPage;
import pageobjects.SentLettersPage;

import java.time.Duration;


@CucumberOptions(
        features = "src/test/resources",
        glue="cucumber"
        )


public class QualityLabCucumberRunner  extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    public BasePage basePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.close();
    }


}
