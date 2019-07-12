package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.when;

import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:39
 */
public class WhenTest {

    @When("^Test When$")
    public void test_When() throws Throwable {
        assertTrue(true);
    }
}
