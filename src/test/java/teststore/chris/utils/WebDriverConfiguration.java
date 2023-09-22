package teststore.chris.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class WebDriverConfiguration implements WebDriverSetup {

    private WebDriver driver;
    @Override
    public void setDriver(String type) {
        switch (type) {
            case "CHROME_WIN" -> {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            case "CHROME_ARM" -> {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver();
            }
            case "EDGE" -> {
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            case "SAFARI" -> {
                System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
                driver = new SafariDriver();
            }
        }
    }

    @Override
    public WebDriver getDriver(String type) {
        setDriver(type);
        return driver;
    }


//    public WebDriver getChromeDriverOptions(List<String> options) {
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        ChromeOptions chromeOptions = new ChromeOptions();
//        for (String option : options)
//            chromeOptions.addArguments(option);
//
//        driver = new ChromeDriver(chromeOptions);
//        return driver;
//    }

}
