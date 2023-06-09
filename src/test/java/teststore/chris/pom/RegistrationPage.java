package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver webDriver;
    private final By loginButton = new By.ByXPath("//a[normalize-space()='Log in instead!']");
    private final By mrSocialTitle = new By.ByXPath("input[value='1']");
    private final By mrsSocialTitle = new By.ByCssSelector("input[value='2']");
    private final By firstNameField = new By.ByCssSelector("input[name='firstname']");
    private final By lastNameField = new By.ByCssSelector("input[name='lastname']");
    private final By emailField = new By.ByCssSelector("input[name='email']");
    private final By passwordField = new By.ByCssSelector("input[name='password']");
    private final By birthDayField = new By.ByCssSelector("input[placeholder='MM/DD/YYYY']");
    private final By offersCheckbox = new By.ByCssSelector("input[value='1'][name='optin']");
    private final By newsletterCheckbox = new By.ByCssSelector("input[value='1'][name='newsletter']");
    private final By policyAgreementCheckbox = new By.ByCssSelector("input[value='1'][name='psgdpr']");
    private final By saveButton = new By.ByXPath("//button[normalize-space()='Save']");
}
