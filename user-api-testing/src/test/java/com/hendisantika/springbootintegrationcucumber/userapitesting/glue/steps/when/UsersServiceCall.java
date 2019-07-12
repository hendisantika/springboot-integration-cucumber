package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.when;

import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.dto.UserDto;
import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.resource.UserApiResource;
import cucumber.api.java.en.When;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:40
 */
@Slf4j
@RequiredArgsConstructor
public class UsersServiceCall {

    @Getter
    @NonNull
    private UserApiResource resource;

    @Getter
    private List<UserDto> users;

    @When("^getAllUsers service is invoked$")
    public void users_service_is_invoked() throws Throwable {
        log.info("UsersServiceCall.users_service_is_invoked()");
        this.users = this.resource.getUsers("/users", null);
    }

    @When("^getAllUsersExceptDefaultData service is invoked$")
    public void getAllUsersExceptDefaultData() throws Throwable {
        log.info("UsersServiceCall.users_service_is_invoked()");
        this.users = this.resource.getUsers("/usersExceptDefault", null);
    }

    @When("^getUserById service is invoked \"([^\"]*)\"$")
    public void getuserbyid_service_is_invoked(String id) throws Throwable {
        this.users = this.resource.getUsers("/users", id);
    }

}
