package teststore.chris.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import teststore.chris.TestRunner;

import teststore.chris.pom.HomePage;
import teststore.chris.pom.RegistrationPage;
import teststore.chris.pom.SignInPage;
import teststore.chris.utils.WebDriverSetup;

import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpStepdefs {
    private WebDriverSetup driverSetup;
    private WebDriver driver;
    private SignInPage signInPage;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private ResourceBundle resourceBundle;
    private String browserName;

    private String userName;
    private static final Logger logger = LogManager.getLogger(TestRunner.class);


    @Before("@CreateUser")
    public void setup() {
        driverSetup = new WebDriverSetup();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
    }

    @After("@CreateUser")
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status =======> " + scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.close();
        driver.quit();
    }

    @Given("I lunch browser")
    public void iLunchBrowser() {
        if (browserName.equals("chrome"))
            driver = driverSetup.getChromeDriver();
        if (browserName.equals("edge"))
            driver = driverSetup.getEdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("I go to the Sign in page")
    public void iGoToTheSignInPage() {
        homePage = new HomePage(driver);
        signInPage = homePage.goToSignInPage();
    }

    @When("I press on No account? Create one here")
    public void iPressOnNoAccountCreateOneHere() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        registrationPage = signInPage.goToRegistration();
    }

    @Then("I am on Registration page")
    public void iamOnRegistrationPage() {
        assertTrue("Create an account".equalsIgnoreCase(driver.findElement(By.cssSelector("header[class='page-header'] h1")).getText()));
    }

    @And("I go to Registration page")
    public void igoToRegistrationPage() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegistrationPage();
    }

    @When("I select Mr.")
    public void iSelectMr() {
        registrationPage.selectSocialTitleMr();
    }

    @And("enter first name {string} and last name {string}")
    public void enterFirstAndLastName(String fName, String lName) {
        userName = fName + " " + lName;
        registrationPage.enterFirstName(fName);
        registrationPage.enterLastName(lName);
    }

    @And("enter email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }

    @And("enter birthdate {string}")
    public void enterBirthdate(String bDay) {
        registrationPage.enterBirthDate(bDay);
    }

    @And("tick all checkboxes")
    public void tickAllCheckboxes() {
        registrationPage.tickNewsletter();
        registrationPage.tickOffers();
        registrationPage.tickPolicyAgreement();
    }

    @And("press on Save button")
    public void pressOnSaveButton() {
        registrationPage.clickSave();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I am logged in")
    public void i_am_logged_in() {
        String accountName = driver.findElement(By.xpath("//span[normalize-space()='"+ userName + "']")).getText();
        assertTrue(userName.equalsIgnoreCase(accountName));
    }

    @Then("I remain on Registration page")
    public void iRemainOnRegistrationPage() {
    }

    @When("I select Mrs.")
    public void iSelectMrs() {
        registrationPage.selectSocialTitleMrs();
    }

    @And("not entering first and last name")
    public void notEnteringFirstAndLastName() {
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
    }

    @And("enter new email {string} and password {string}")
    public void enterNewEmailAndPassword(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }
}
