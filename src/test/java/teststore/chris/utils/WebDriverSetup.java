package teststore.chris.utils;

import org.openqa.selenium.WebDriver;

public interface WebDriverSetup {
    void setDriver(String driverType);
    WebDriver getDriver(String driverType);
}
