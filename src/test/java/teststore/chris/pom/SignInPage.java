package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver webDriver;
    private final By emailField = new By.ByCssSelector("input[class='form-control']");
    private final By passwordField = new By.ByCssSelector("input[title='At least 5 characters long']");
    private final By signInButton = new By.ByCssSelector("#submit-login");
    private final By forgotPasswordButton = new By.ByXPath("//a[normalize-space()='Forgot your password?']");
    private final By createAccountButton = new By.ByXPath("//a[normalize-space()='No account? Create one here']");
    private final By logInToYourAccountH1 = new By.ByXPath("//section[@id='main']//h1[1]");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RegistrationPage goToRegistration(){
        clickOnCreateAccount();
        return new RegistrationPage(webDriver);
    }

    private void clickOnCreateAccount() {
        webDriver.findElement(createAccountButton).click();
    }

    public void clickOnForgotPassword() {
        webDriver.findElement(forgotPasswordButton).click();
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void clickOnSignIn() {
        webDriver.findElement(signInButton).click();
    }
    public WebElement getH1LogInToYourAccount() {
        return webDriver.findElement(logInToYourAccountH1);
    }

}
