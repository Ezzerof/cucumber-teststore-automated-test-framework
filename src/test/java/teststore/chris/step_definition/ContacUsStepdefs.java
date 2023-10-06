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
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import teststore.chris.TestRunner;
import teststore.chris.pom.ContactUsPage;
import teststore.chris.pom.HomePage;
import teststore.chris.utils.WebDriverConfiguration;

import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class ContacUsStepdefs {
    private ContactUsPage contactUsPage;
    private WebDriver driver;
    private WebDriverConfiguration driverSetup;
    private ResourceBundle resourceBundle;
    private HomePage homePage;
    private String browserName;
    private static final Logger logger = LogManager.getLogger(TestRunner.class);


    @Before("@ContactUs")
    public void setup() {
        driverSetup = new WebDriverConfiguration();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
        driver = driverSetup.getDriver(browserName);
    }

    @After("@ContactUs")
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

    @Given("I lunch browser")
    public void iLunchBrowser() {
        driver.manage().window().maximize();
    }

    @When("I go to Contact us page")
    public void iGoToContactUsPage() {
        homePage = new HomePage(driver);
        contactUsPage = homePage.goToContactUsPage();
    }

    @Then("I am on the Contact us page")
    public void iAmOnTheContactUsPage() {
        String expectedPageTitle = "Contact us";
        String actualPageTitle = driver.getTitle();

        logger.info("Expected page title: {}", expectedPageTitle);
        logger.info("Actual page title: {}", actualPageTitle);

        assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Given("I am on Contact us page")
    public void iAmOnContactUsPage() {

    }

    @And("I select as a subject customer service")
    public void iSelectAsASubjectCustomerService() {
    }

    @And("I enter a message {string}")
    public void iEnterAMessage(String msg) {
    }

    @And("I tick the checkbox")
    public void iTickTheCheckbox() {
    }

    @When("I press on Send button")
    public void iPressOnSendButton() {
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String arg0) {
    }
}
