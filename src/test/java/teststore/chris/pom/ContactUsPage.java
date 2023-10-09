package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver webDriver;
    private final By subjectSelector = new By.ByCssSelector("select[name='id_contact']");
    private final By emailField = new By.ByCssSelector("input[placeholder='your@email.com']");
    private final By messageField = new By.ByCssSelector("textarea[placeholder='How can we help?']");
    private final By checkbox = new By.ByCssSelector("#psgdpr_consent_checkbox_1");
    private final By sendButton = new By.ByCssSelector("input[value='Send']");
    private final By confirmationMessage = new By.ByCssSelector("div[class='col-xs-12 alert alert-success'] ul li");

    public ContactUsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String checkMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return element.getText();
    }
    public void clickSend() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        element.click();
    }

    public WebElement tickCheckbox() {
        WebElement element = webDriver.findElement(checkbox);
        element.click();
        return element;
    }

    public String selectCustomerService() {
        Select selector = new Select(webDriver.findElement(subjectSelector));
        WebElement element = selector.getFirstSelectedOption();
        return element.getText();
    }
    public String selectWebmaster() {
        Select selector = new Select(webDriver.findElement(subjectSelector));
        selector.selectByIndex(1);
        WebElement element = selector.getFirstSelectedOption();
        return element.getText();
    }
    public void enterMessage(String message) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(messageField)));
        element.sendKeys(message);
    }
    public WebElement enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(emailField)));
        element.sendKeys(email);
        return element;
    }
}
