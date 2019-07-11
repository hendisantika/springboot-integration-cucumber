package com.hendisantika.springbootintegrationcucumber.userapitesting.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-12
 * Time: 05:38
 */
@Data
@EqualsAndHashCode
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String state;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }
}

