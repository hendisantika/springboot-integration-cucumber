package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.then;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:37
 */
public class ThenTest {

    @Then("^Test Then$")
    public void test_Then() throws Throwable {
        assertTrue(true);
    }

}
