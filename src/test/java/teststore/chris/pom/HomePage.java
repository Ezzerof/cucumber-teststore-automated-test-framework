package teststore.chris.pom;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver webDriver;
    private final By signInButton = new By.ByXPath("//span[normalize-space()='Sign in']");
    private final By cartButton = new By.ByXPath("//span[normalize-space()='Cart']");
    private final By contactUsButton = new By.ByCssSelector("div[id='contact-link'] a");
    private final By clothesButton = new By.ByXPath("//li[@id='category-3']//a[@class='dropdown-item']");
    private final By accessoriesButton = new By.ByXPath("//li[@id='category-6']//a[@class='dropdown-item']");
    private final By artButton = new By.ByXPath("//a[normalize-space()='Art']");
    private final By searchBar = new By.ByCssSelector("input[placeholder='Search our catalog']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    public void goToHomePage() {
        webDriver.get("http://teststore.automationtesting.co.uk/");
    }
    public SignInPage goToSignInPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        element.click();
        return new SignInPage(webDriver);
    }

    public ContactUsPage goToContactUsPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
        element.click();
        return new ContactUsPage(webDriver);
    }
}
