package teststore.chris.stepdefinition;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import teststore.chris.pages.HomePage;
import teststore.chris.pages.SignInPage;
import teststore.chris.utils.WebDriverConfiguration;

import java.time.Duration;
import java.util.ResourceBundle;

import static org.junit.Assert.*;


public class LogInSteps {
    private WebDriverConfiguration driverSetup;
    private WebDriver driver;
    private SignInPage signInPage;
    private HomePage homePage;
    private ResourceBundle resourceBundle;
    private String browserName;
    private static final Logger logger = LogManager.getLogger(LogInSteps.class);



    @Before("@LogIn")
    public void setup() {
        driverSetup = new WebDriverConfiguration();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
        driver = driverSetup.getDriver(browserName);
        Point p = new Point(0, 0);
        driver.manage().window().setPosition(p);
        driver.manage().window().setSize(new Dimension(1000, 800));
    }

    @After("@LogIn")
    public void tearDown(Scenario scenario) {
        try {
            System.out.println("Scenario status =======> " + scenario.getStatus());
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (NoSuchSessionException e) {
            logger.error("WebDriver session is not available. Restarting the session if needed.");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Given("I lunch the browser")
    public void iLunchTheBrowser() {
        driver.manage().window().maximize();
    }

    @And("I go to Log in page")
    public void iGoToLogInPage() {
        homePage = new HomePage(driver);
        signInPage = homePage.goToSignInPage();
    }

    @When("I enter a valid email {string}")
    public void iEnterAValidEmail(String email) {
        signInPage.enterEmail(email);
    }

    @And("I then enter password {string}")
    public void iThenEnterPassword(String password) {
        signInPage.enterPassword(password);
        signInPage.clickOnSignIn();

    }

    @Then("I will go to my account")
    public void iWillGoToMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean flag = wait.until(ExpectedConditions.titleContains("My account"));
        assertTrue(flag);
    }

    @When("I enter invalid email {string}")
    public void iEnterInvalidEmail(String email) {
        signInPage.enterEmail(email);
    }

    @And("I enter an invalid password {string}")
    public void iEnterAnInvalidPassword(String password) {
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
