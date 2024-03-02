package teststore.chris.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private WebDriver webDriver;
    private final By emailField = new By.ByCssSelector("#email");
    private final By sendButton = new By.ByXPath("//button[normalize-space()='Send reset link']");
    private final By confirmationMessage = new By.ByCssSelector("li[class='item'] p");
}
