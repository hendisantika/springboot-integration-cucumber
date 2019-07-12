package com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.then;

import com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.given.Users;
import com.hendisantika.springbootintegrationcucumber.userapitesting.glue.steps.when.UsersServiceCall;
import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.dto.UserDto;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-13
 * Time: 05:38
 */
@RequiredArgsConstructor
public class UsersServiceValidation {

    @NonNull
    private Users users;

    @NonNull
    private UsersServiceCall usersServiceCall;

    @Then("^\"([^\"]*)\" users should exist$")
    public void users_should_exist(String expectedNumberOfUsers) throws Throwable {
        assertNotNull(this.usersServiceCall);
        assertNotNull(this.usersServiceCall.getUsers());
        assertEquals(expectedNumberOfUsers, String.valueOf(this.usersServiceCall.getUsers().size()));
    }

    @Then("^user below should exist$")
    public void user_below_should_exist(DataTable expectedUsers) throws Throwable {
        List<Map<String, String>> usersExpected = expectedUsers.asMaps(String.class, String.class);
        UserDto[] expectedUserDtos = this.users.getUsersDto(usersExpected);
        List<UserDto> usersActual = this.usersServiceCall.getUsers();
        List<UserDto> usersActualDto = usersActual.stream()
                .map(user -> {
                    return new UserDto(user.getFirstName(), user.getLastName(), user.getState());
                }).collect(Collectors.toList());

        assertArrayEquals(expectedUserDtos, usersActualDto.toArray());
    }

    @Then("^user with following name should exist \"([^\"]*)\"$")
    public void user_with_following_name_should_exist(String expectedUsername) throws Throwable {
        List<UserDto> usersActual = this.usersServiceCall.getUsers();
        assertNotNull(usersActual);
        assertEquals(1, usersActual.size());
        long count = usersActual.stream()
                .filter(user -> user.getFirstName().equals(expectedUsername))
                .count();
        assertEquals(1L, count);
    }
}

