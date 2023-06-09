package teststore.chris.pom;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        webDriver.findElement(signInButton).click();
        return new SignInPage(webDriver);
    }
}
