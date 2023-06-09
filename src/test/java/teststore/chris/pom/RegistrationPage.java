package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver webDriver;
    private final By loginButton = new By.ByXPath("//a[normalize-space()='Log in instead!']");
    private final By mrSocialTitle = new By.ByXPath("//label[normalize-space()='Mr.']//span[@class='custom-radio']");
    private final By mrsSocialTitle = new By.ByCssSelector("//label[normalize-space()='Mr.']//span[@class='custom-radio']");
    private final By firstNameField = new By.ByCssSelector("input[name='firstname']");
    private final By lastNameField = new By.ByCssSelector("input[name='lastname']");
    private final By emailField = new By.ByCssSelector("input[name='email']");
    private final By passwordField = new By.ByCssSelector("input[name='password']");
    private final By birthDayField = new By.ByCssSelector("input[placeholder='MM/DD/YYYY']");
    private final By offersCheckbox = new By.ByCssSelector("input[value='1'][name='optin']");
    private final By newsletterCheckbox = new By.ByCssSelector("input[value='1'][name='newsletter']");
    private final By policyAgreementCheckbox = new By.ByCssSelector("input[value='1'][name='psgdpr']");
    private final By saveButton = new By.ByXPath("//button[normalize-space()='Save']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToRegistrationPage() {
        webDriver.get("http://teststore.automationtesting.co.uk/login?create_account=1");
    }

    public void selectSocialTitleMr() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement mrCheckbox = webDriver.findElement(mrSocialTitle);
        wait.until(ExpectedConditions.elementToBeClickable(mrCheckbox)).click();
    }

    public void selectSocialTitleMrs() {
        webDriver.findElement(mrsSocialTitle).click();
    }

    public void enterFirstName(String name) {
        webDriver.findElement(firstNameField).sendKeys(name);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void enterBirthDate(String birthDate) {
        webDriver.findElement(birthDayField).sendKeys(birthDate);
    }

    public void tickOffers() {
        webDriver.findElement(offersCheckbox).click();
    }

    public void tickNewsletter() {
        webDriver.findElement(newsletterCheckbox).click();
    }

    public void tickPolicyAgreement() {
        webDriver.findElement(policyAgreementCheckbox).click();
    }

    public void clickSave() {
        webDriver.findElement(saveButton).click();
    }

    public void clickLogin() {
        webDriver.findElement(loginButton).click();
    }
}
