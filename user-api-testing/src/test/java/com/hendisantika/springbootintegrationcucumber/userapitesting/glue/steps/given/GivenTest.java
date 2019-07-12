package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.given;

import cucumber.api.java.en.Given;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:36
 */
public class GivenTest {

    @Given("^Test Given$")
    public void test_Given() throws Throwable {
        assertTrue(true);
    }
}