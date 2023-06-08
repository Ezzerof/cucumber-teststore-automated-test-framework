package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver webDriver;
    private final By emailField = new By.ByCssSelector("input[class='form-control']");
    private final By passwordField = new By.ByCssSelector("input[title='At least 5 characters long']");
    private final By signInButton = new By.ByCssSelector("#submit-login");
    private final By forgotPasswordButton = new By.ByXPath("//a[normalize-space()='Forgot your password?']");
    private final By createAccountButton = new By.ByXPath("//a[normalize-space()='No account? Create one here']");


}
