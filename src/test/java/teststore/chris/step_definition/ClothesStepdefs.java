package teststore.chris.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import teststore.chris.pom.ClothesPage;
import teststore.chris.pom.HomePage;
import teststore.chris.utils.WebDriverConfiguration;

import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class ClothesStepdefs {

    private ClothesPage clothesPage;
    private HomePage homePage;
    private WebDriverConfiguration driverSetup;
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ClothesStepdefs.class);

    @Before("@Clothes")
    public void setup() {
        driverSetup = new WebDriverConfiguration();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        String browserName = resourceBundle.getString("browser");
        driver = driverSetup.getDriver(browserName);
        Point p = new Point(0, 0);
        driver.manage().window().setPosition(p);
        driver.manage().window().setSize(new Dimension(1000, 800));
    }

    @After("@Clothes")
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

    @Given("I go to Home page")
    public void iGoToHomePage() {
        homePage = new HomePage(driver);
    }

    @When("I click to Clothes button")
    public void iClickToClothesButton() {
        clothesPage = homePage.goToClothesPage();
    }

    @Then("I am on the Clothes page")
    public void iAmOnTheClothesPage() {
        String expectedPageTitle = "Clothes";
        String actualPageTitle = driver.getTitle();

        if (!expectedPageTitle.equals(actualPageTitle)) {
            logger.info("Step failed - Wrong page");
            logger.warn("Expected page title: {}", expectedPageTitle);
            logger.warn("Actual page title: {}", actualPageTitle);
        }

        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
