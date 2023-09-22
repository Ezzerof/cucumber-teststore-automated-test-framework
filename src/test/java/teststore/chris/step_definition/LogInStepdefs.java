package teststore.chris.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import teststore.chris.TestRunner;
import teststore.chris.pom.HomePage;
import teststore.chris.pom.SignInPage;
import teststore.chris.utils.WebDriverConfiguration;

import java.time.Duration;
import java.util.ResourceBundle;

import static org.junit.Assert.*;


public class LogInStepdefs {
    private WebDriverConfiguration driverSetup;
    private WebDriver driver;
    private SignInPage signInPage;
    private HomePage homePage;
    private ResourceBundle resourceBundle;
    private String browserName;
    private static final Logger logger = LogManager.getLogger(TestRunner.class);



    @Before("@LogIn")
    public void setup() {
        driverSetup = new WebDriverConfiguration();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
    }

    @After("@LogIn")
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status =======> " + scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.close();
        driver.quit();
    }

    @Given("I lunch the browser")
    public void iLunchTheBrowser() {
        driver = driverSetup.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("I go to Log in page")
    public void iGoToLogInPage() {
        homePage = new HomePage(driver);
        signInPage = homePage.goToSignInPage();
    }

    @When("I enter {string}")
    public void iEnter(String email) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        signInPage.enterEmail(email);
    }

    @And("I then enter {string}")
    public void iThenEnter(String password) {
        signInPage.enterPassword(password);
        signInPage.clickOnSignIn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I will go to my account")
    public void iWillGoToMyAccount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actual = driver.getTitle();
        assertEquals("My account", actual.strip());
    }

    @When("I enter invalid {string}")
    public void iEnterInvalid(String email) {
        signInPage.enterEmail(email);
    }

    @And("I enter an invalid {string}")
    public void iEnterAnInvalid(String password) {
        signInPage.enterPassword(password);
    }

    @Then("I will remain on Log in page")
    public void iWillRemainOnLogInPage() {
        assertTrue(!signInPage.getH1LogInToYourAccount().getText().isEmpty());
    }

    @When("I click on sing in button")
    public void iClickOnSingInButton() {
        signInPage.clickOnSignIn();
    }
}
