package teststore.chris.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class WebDriverSetup {

    private WebDriver driver;
    private final String chromeDriverPath = "src/test/resources/chromedriver.exe";
    private final String edgeDriverPath = "src/test/resources/msedgedriver.exe";

    private void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    private void setEdgeDriver() {
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        driver = new EdgeDriver();
    }
    public WebDriver getChromeDriver() {
        setChromeDriver();
        return driver;
    }

    public WebDriver getChromeDriverOptions(List<String> options) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        for (String option : options)
            chromeOptions.addArguments(option);

        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public WebDriver getEdgeDriver() {
        setEdgeDriver();
        return driver;
    }

}
