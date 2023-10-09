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
import teststore.chris.pom.ContactUsPage;
import teststore.chris.pom.HomePage;
import teststore.chris.utils.WebDriverConfiguration;

import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Given("lunch the browser")
    public void lunchTheBrowser() {
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @When("I go to Contact us page")
    public void iGoToContactUsPage() {
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

    @And("I select as a subject customer service")
    public void iSelectAsASubjectCustomerService() {
        String actualSubject = contactUsPage.selectCustomerService();
        String expectedSubject = "Customer service";

        if (actualSubject.equals(expectedSubject))
            logger.info("Test passed");
        else
            logger.info("Test failed - Wrong Subject selected");

        logger.debug("Actual selection is: {}", actualSubject);
        logger.debug("Expected selection is: {}", expectedSubject);

        assertEquals(actualSubject, expectedSubject);
    }

    @And("I enter a message {string}")
    public void iEnterAMessage(String msg) {
        contactUsPage.enterMessage(msg);
        String actualMessage = driver.findElement(By.xpath("textarea[placeholder='How can we help?']")).getAttribute("value");

        if (actualMessage.equals(msg))
            logger.info("Test passed");
        else
            logger.info("Test failed - Message mismatch");

        logger.debug("Actual message is: {}", actualMessage);
        logger.debug("Expected message is: {}", msg);

        assertEquals(actualMessage, msg);
    }

    @And("I tick the checkbox")
    public void iTickTheCheckbox() {
        WebElement checkbox = contactUsPage.tickCheckbox();

        if (!checkbox.isSelected())
            logger.info("Step failed - Checkbox not selected");

        assertTrue(checkbox.isSelected());
    }

    @When("I press on Send button")
    public void iPressOnSendButton() {
        contactUsPage.clickSend();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String msg) {
        String actualMessage = contactUsPage.checkMessage();

        if (!actualMessage.equals(msg)) {
            logger.warn("Wrong message: {}", actualMessage);
        }

        assertEquals(msg, actualMessage);
    }

    @And("I enter an email {string}")
    public void iEnterAnEmail(String email) {
        WebElement emailField = contactUsPage.enterEmail(email);
        String actualEmail = emailField.getAttribute("value");

        if (actualEmail.equals(email))
            logger.info("Test passed");
        else
            logger.info("Test failed - Email mismatch");

        logger.debug("Actual email: {}", actualEmail);
        logger.debug("Expected email: {}", email);

        assertEquals(actualEmail, email);
    }
}
