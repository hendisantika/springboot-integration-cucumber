package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.hook;

import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.resource.UserApiResource;
import cucumber.api.java.Before;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:32
 */
@Slf4j
@RequiredArgsConstructor
public class DropUsers {

    @NonNull
    private UserApiResource userApiResource;

    @Before("@dropUsers")
    public void tearDownUsers() {
        this.userApiResource.deleteAddedUser();
        log.info("Users deleted from DropUsers.tearDownUsers()");
    }
}