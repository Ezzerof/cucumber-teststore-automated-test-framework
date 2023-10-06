package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
