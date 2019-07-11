package com.hendisantika.springbootintegrationcucumber.userapitesting.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-12
 * Time: 05:35
 */
@Slf4j
public class ApplicationProperties extends Properties {

    public ApplicationProperties() {

        Properties systemProperties = System.getProperties();
        String envName = systemProperties.getProperty("config.env");

        String propertiesFileName = envName != null ? String.format("application-%s.properties", envName) : "application.properties";

        try {
            InputStream properties = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName);
            this.load(properties);
        } catch (IOException e) {
            log.error("Error occured in ApplicationProperties.class", e.getMessage());
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }
}