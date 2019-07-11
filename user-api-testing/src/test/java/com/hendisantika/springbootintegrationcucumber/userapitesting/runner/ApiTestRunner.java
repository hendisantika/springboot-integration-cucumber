package com.hendisantika.springbootintegrationcucumber.userapitesting.runner;

import com.hendisantika.springbootintegrationcucumber.userapitesting.config.ApplicationProperties;
import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.resource.UserApiResource;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-12
 * Time: 05:42
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "html:target/cucumber/api",
                "json:target/reports/cucumber/api.json"
        },
        tags = {"~@ignored", "@api"},
        features = "classpath:feature",
        glue = {"classpath:glue"}
)
public class ApiTestRunner {

    @AfterClass
    public static void dropDown() {
        //Runs only once after all suite
        ApplicationProperties properties = new ApplicationProperties();
        UserApiResource userApiResource = new UserApiResource(properties);
//        DropUsers dropUsers = new DropUsers(userApiResource);
//        dropUsers.tearDownUsers();
    }

    @BeforeClass
    public static void setUp() {
        //Runs only once before test
    }
}