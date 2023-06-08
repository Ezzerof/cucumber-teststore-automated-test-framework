package teststore.chris.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver webDriver;
    private final By proceedToCheckoutButton = new By.ByCssSelector("a[class='btn btn-primary']");
    private final By deleteItem = new By.ByCssSelector(".material-icons.float-xs-left");
    private final By increaseItem = new By.ByCssSelector(".material-icons.touchspin-up");
    private final By decreaseItem = new By.ByCssSelector(".material-icons.touchspin-down");
    private final By continueShopping = new By.ByXPath("//body/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/div[@class='cart-grid row']/div[@class='cart-grid-body col-xs-12 col-lg-8']/a[1]");
}
