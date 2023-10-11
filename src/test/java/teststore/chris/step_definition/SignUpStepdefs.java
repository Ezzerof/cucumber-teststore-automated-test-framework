package teststore.chris.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import teststore.chris.TestRunner;

import teststore.chris.pom.HomePage;
import teststore.chris.pom.RegistrationPage;
import teststore.chris.pom.SignInPage;
import teststore.chris.utils.WebDriverConfiguration;

import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpStepdefs {
    private WebDriverConfiguration driverSetup;
    private WebDriver driver;
    private SignInPage signInPage;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private ResourceBundle resourceBundle;
    private String browserName;

    private StringBuilder userName = new StringBuilder();
    private static final Logger logger = LogManager.getLogger(TestRunner.class);


    @Before("@CreateUser")
    public void setup() {
        driverSetup = new WebDriverConfiguration();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
        driver = driverSetup.getDriver(browserName);
        Point p = new Point(0, 0);
        driver.manage().window().setPosition(p);
        driver.manage().window().setSize(new Dimension(1000, 800));
    }

    @After("@CreateUser")
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

    @And("I go to the Sign in page")
    public void iGoToTheSignInPage() {
        homePage = new HomePage(driver);
        signInPage = homePage.goToSignInPage();
    }

    @When("I press on No account? Create one here")
    public void iPressOnNoAccountCreateOneHere() {
        registrationPage = signInPage.goToRegistration();
    }

    @Then("I am on Registration page")
    public void iamOnRegistrationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Create an account']")));
        assertTrue("Create an account".equalsIgnoreCase(element.getText().strip()));
    }

    @And("I go to Registration page")
    public void igoToRegistrationPage() {
        homePage = new HomePage(driver);
        signInPage = homePage.goToSignInPage();
        registrationPage = signInPage.goToRegistration();
    }

    @When("I select Mr.")
    public void iSelectMr() {
        registrationPage.selectSocialTitleMr();
    }

    @And("enter first name {string}")
    public void enterFirstName(String fName) {
        registrationPage.enterFirstName(fName);

        userName.append(fName);

        logger.info("Entered first name: {}", fName);

        String actualFirstName = driver.findElement(By.cssSelector("input[name='firstname']")).getAttribute("value");

        logger.info("Actual first name: {}", actualFirstName);

        assertEquals(actualFirstName, fName);
    }

    @And("enter last name {string}")
    public void enterLastName(String lName) {
        registrationPage.enterLastName(lName);

        logger.info("Entered last name: {}", lName);

        userName.append(" ");
        userName.append(lName);

        String actualLastName = driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value");

        logger.info("Actual last name: {}", actualLastName);

        assertEquals(actualLastName, lName);
    }

    @And("enter email {string}")
    public void enterEmail(String email) {
        registrationPage.enterEmail(email);

        logger.info("Entered email: {}", email);

        String actualEmail = driver.findElement(By.cssSelector("input[name='email']")).getAttribute("value");

        logger.info("Actual email: {}", actualEmail);

        assertEquals(actualEmail, email);
    }

    @And("enter password {string}")
    public void enterPassword(String password) {
        registrationPage.enterPassword(password);

        logger.info("Entered password: {}", password);

        String actualPassword = driver.findElement(By.cssSelector("input[name='password']")).getAttribute("value");

        logger.info("Actual password: {}", actualPassword);

        assertEquals(actualPassword, password);
    }


    @And("enter birthdate {string}")
    public void enterBirthdate(String bDay) {
        registrationPage.enterBirthDate(bDay);

        logger.info("Entered birth day: {}", bDay);

        String actualBDay = driver.findElement(By.cssSelector("input[placeholder='MM/DD/YYYY']")).getAttribute("value");

        logger.info("Actual birth day: {}", actualBDay);

        assertEquals(actualBDay, bDay);
    }

    @And("tick all checkboxes")
    public void tickAllCheckboxes() {
        registrationPage.tickOffers();
        registrationPage.tickNewsletter();
        registrationPage.tickPolicyAgreement();
    }

    @And("tick sign up for newsletters checkbox")
    public void tickSignUpForNewslettersCheckbox() {
        registrationPage.tickNewsletter();
    }

    @And("tick agree terms checkbox")
    public void tickAgreeTermsCheckbox() {
        registrationPage.tickPolicyAgreement();
    }

    @And("tick to receive offers checkbox")
    public void tickToReceiveCheckbox() {
        registrationPage.tickOffers();
    }

    @And("press on Save button")
    public void pressOnSaveButton() {
        registrationPage.clickSave();
    }

    @Then("I am logged in")
    public void i_am_logged_in() {
        String accountName = driver.findElement(By.xpath("//span[normalize-space()='"+ userName + "']")).getText();

        if (userName.toString().equalsIgnoreCase(accountName))
            logger.info("User is logged in.");
        else
            logger.info("User is NOT logged in.");

        assertTrue(userName.toString().equalsIgnoreCase(accountName));
        userName.setLength(0);
    }

    @Then("I remain on Registration page")
    public void iRemainOnRegistrationPage() {
    }

    @When("I select Mrs.")
    public void iSelectMrs() {
        registrationPage.selectSocialTitleMrs();
    }

    @And("not entering first name")
    public void notEnteringFirstName() {
    }

    @And("not entering last name")
    public void notEnteringLastName() {
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'The email is already used, please choose another o')]")));
        String actualMessage = errorAlert.getText();

        logger.info("Error message: {}", actualMessage);

        assertFalse(actualMessage.isEmpty());
    }

    @Then("I see error message under first name field")
    public void iSeeErrorMessageUnderFirstNameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Invalid name')]")));
        String actualMessage = errorAlert.getText();

        logger.info("Error message: {}", actualMessage);

        assertFalse(actualMessage.isEmpty());
    }

    @Then("I see error message under last name field")
    public void iSeeErrorMessageUnderLastNameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Invalid name')]")));
        String actualMessage = errorAlert.getText();

        logger.info("Error message: {}", actualMessage);

        assertFalse(actualMessage.isEmpty());
    }

    @And("enter new email {string} and password {string}")
    public void enterNewEmailAndPassword(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);

        logger.info("Entered email: {}", email);
        logger.info("Entered password: {}", password);

        String actualEmail = driver.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
        String actualPassword = driver.findElement(By.cssSelector("input[name='password']")).getAttribute("value");

        logger.info("Actual email: {}", actualEmail);
        logger.info("Actual password: {}", actualPassword);

        assertEquals(actualEmail, email);
        assertEquals(actualPassword, password);
    }

    @Then("Mr is selected")
    public void mrIsSelected() {
        if (registrationPage.isMrSelected())
            logger.info("Mr. is selected");
        else
            logger.info("Mr. is NOT selected");

        assertTrue(registrationPage.isMrSelected());
    }

    @Then("Mrs is selected")
    public void mrsIsSelected() {
        if (registrationPage.isMrsSelected())
            logger.info("Mrs. is selected");
        else
            logger.info("Mrs. is NOT selected");

        assertTrue(registrationPage.isMrsSelected());
    }

    @And("enter first name with digits {string}")
    public void enterFirstNameWithDigits(String fName) {
        registrationPage.enterFirstName(fName);

        userName.setLength(0);
        userName.append(fName);

        logger.info("Entered first name: {}", fName);

        String actualFirstName = driver.findElement(By.cssSelector("input[name='firstname']")).getAttribute("value");

        logger.info("Actual first name: {}", actualFirstName);

        assertEquals(actualFirstName, fName);
    }
}
