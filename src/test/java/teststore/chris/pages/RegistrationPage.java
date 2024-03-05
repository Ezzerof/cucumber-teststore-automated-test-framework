package teststore.chris.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
@Component
public class RegistrationPage {
    private WebDriver webDriver;
    private final By loginButton = new By.ByXPath("//a[normalize-space()='Log in instead!']");
    private final By mrSocialTitle = new By.ByXPath("//label[normalize-space()='Mr.']");
    private final By mrsSocialTitle = new By.ByXPath("//label[normalize-space()='Mrs.']");
    private final By firstNameField = new By.ByCssSelector("input[name='firstname']");
    private final By lastNameField = new By.ByCssSelector("input[name='lastname']");
    private final By emailField = new By.ByCssSelector("input[name='email']");
    private final By passwordField = new By.ByCssSelector("input[name='password']");
    private final By birthDayField = new By.ByCssSelector("input[placeholder='MM/DD/YYYY']");
    private final By offersCheckbox = new By.ByXPath("//input[@name='optin']");
    private final By newsletterCheckbox = new By.ByXPath("//input[@name='newsletter']");
    private final By policyAgreementCheckbox = new By.ByXPath("//input[@name='psgdpr']");
    private final By saveButton = new By.ByXPath("//button[normalize-space()='Save']");
    private WebDriverWait wait;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    public void selectSocialTitleMr() {
        WebElement mrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(mrSocialTitle));
        mrCheckbox.click();
    }

    public void selectSocialTitleMrs() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mrsSocialTitle));
        element.click();
    }

    public void enterFirstName(String name) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        element.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        element.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        element.sendKeys(password);
    }

    public void enterBirthDate(String birthDate) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(birthDayField));
        element.sendKeys(birthDate);
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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        element.click();
    }

    public void clickLogin() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        element.click();
    }

    public boolean isMrSelected() {
        WebElement mrRadio = wait.until(ExpectedConditions.elementToBeClickable(mrSocialTitle));
        WebElement checkedRadioBox = webDriver.findElement(By.xpath("(//span)[12]"));
        return checkedRadioBox.isDisplayed();
    }
    public boolean isMrsSelected() {
        WebElement mrsRadio = wait.until(ExpectedConditions.elementToBeClickable(mrsSocialTitle));
        WebElement checkedRadioBox = webDriver.findElement(By.xpath("(//span)[14]"));
        return checkedRadioBox.isDisplayed();
    }

}
