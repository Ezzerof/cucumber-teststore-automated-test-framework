package teststore.chris.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties
public class SpringSeleniumProperties {
    @Value("${host}")
    private String host;
    @Value("${browser}")
    private String browser;
    @Value("${context}")
    private String context;
}
