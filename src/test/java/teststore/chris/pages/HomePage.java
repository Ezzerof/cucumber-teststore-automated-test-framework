package teststore.chris.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
@Component
public class HomePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private final By signInButton = By.xpath("//span[normalize-space()='Sign in']");
    private final By cartButton = By.xpath("//span[normalize-space()='Cart']");
    private final By contactUsButton = By.cssSelector("div[id='contact-link'] a");
    private final By clothesButton = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    private final By accessoriesButton = By.xpath("//li[@id='category-6']//a[@class='dropdown-item']");
    private final By artButton = By.xpath("//a[normalize-space()='Art']");
    private final By searchBar = By.cssSelector("input[placeholder='Search our catalog']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        goToHomePage();
    }

    public void goToHomePage() {
        webDriver.get("http://teststore.automationtesting.co.uk/");
    }
    public SignInPage goToSignInPage() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new SignInPage(webDriver);
    }

    public ContactUsPage goToContactUsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();
        return new ContactUsPage(webDriver);
    }

    public ClothesPage goToClothesPage() {
        wait.until(ExpectedConditions.elementToBeClickable(clothesButton)).click();
        return new ClothesPage(webDriver);
    }
}
