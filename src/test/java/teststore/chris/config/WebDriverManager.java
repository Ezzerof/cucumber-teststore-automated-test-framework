package teststore.chris.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class WebDriverManager {

    @Autowired
    private SpringSeleniumProperties properties;

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriverFactory() {
        return new ChromeDriver();
    }
}
