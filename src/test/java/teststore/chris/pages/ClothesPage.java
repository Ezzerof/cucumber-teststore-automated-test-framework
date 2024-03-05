package teststore.chris.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class ClothesPage {
    private WebDriver webDriver;
    private final By menCategory = new By.ByXPath("//ul[@class='category-sub-menu']//a[contains(text(),'Men')]");
    private final By womenCategory = new By.ByXPath("//ul[@class='category-sub-menu']//a[contains(text(),'Women')]");
    private final By menFilter = new By.ByCssSelector("label[for='facet_input_82157_0'] span[class='ps-shown-by-js']");
    private final By womenFilter = new By.ByCssSelector("label[for='facet_input_82157_1'] span[class='ps-shown-by-js']");
    private final By smallSize = new By.ByCssSelector("label[for='facet_input_26476_0'] span[class='ps-shown-by-js']");
    private final By mediumSize = new By.ByCssSelector("label[for='facet_input_26476_1'] span[class='ps-shown-by-js']");
    private final By largeSize = new By.ByCssSelector("label[for='facet_input_26476_2'] span[class='ps-shown-by-js']");
    private final By extraLargeSize = new By.ByCssSelector("label[for='facet_input_26476_2'] span[class='ps-shown-by-js']");
    private final By whiteColor = new By.ByXPath("//a[normalize-space()='White']");
    private final By blackColor = new By.ByXPath("//a[normalize-space()='Black']");
    private final By longSleeves = new By.ByXPath("//label[@for='facet_input_55858_0']//span[@class='ps-shown-by-js']");
    private final By shortSleeves = new By.ByXPath("//label[@for='facet_input_55858_1']//span[@class='ps-shown-by-js']");
    private final By firstItem = new By.ByCssSelector("img[alt='Hummingbird printed t-shirt']");
    private final By secondItem = new By.ByCssSelector("img[alt='Brown bear printed sweater']");

    public ClothesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
