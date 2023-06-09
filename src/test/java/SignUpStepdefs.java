import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import teststore.chris.pom.RegistrationPage;
import teststore.chris.pom.SignInPage;
import teststore.chris.utils.WebDriverSetup;

import java.util.ResourceBundle;

public class SignUpStepdefs {
    private WebDriverSetup driverSetup;
    private WebDriver driver;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private ResourceBundle resourceBundle;
    private String browserName;

    @Before("@CreateUser")
    public void setup() {
        driverSetup = new WebDriverSetup();
        resourceBundle = ResourceBundle.getBundle("config");
        browserName = resourceBundle.getString("browser");
    }

    @Given("I lunch browser")
    public void iLunchBrowser() {
        if (browserName.equals("chrome"))
            driver = driverSetup.getChromeDriver();
        if (browserName.equals("edge"))
            driver = driverSetup.getEdgeDriver();
    }
    @And("I go to the Sign in page")
    public void iGoToTheSignInPage() {
        driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");
    }

    @When("I press on No account? Create one here")
    public void iPressOnNoAccountCreateOneHere() {
    }

    @Then("I go to Registration page")
    public void iGoToRegistrationPage() {
    }

    @Given("I am on Registration page")
    public void iAmOnRegistrationPage() {
    }

    @When("I select Mr.")
    public void iSelectMr() {
    }

    @And("enter first and last name")
    public void enterFirstAndLastName() {
    }

    @And("enter email and password")
    public void enterEmailAndPassword() {
    }

    @And("enter birthdate")
    public void enterBirthdate() {
    }

    @And("tick all checkboxes")
    public void tickAllCheckboxes() {
    }

    @And("press on Save button")
    public void pressOnSaveButton() {
    }

    @Then("I go to Account page")
    public void iGoToAccountPage() {
    }

    @Then("I remain on Registration page")
    public void iRemainOnRegistrationPage() {
    }

    @When("I select Mrs.")
    public void iSelectMrs() {
    }

    @And("not entering first and last name")
    public void notEnteringFirstAndLastName() {
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
    }

}
