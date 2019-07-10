package com.hendisantika.springboot.integration.cucumber.userapi.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-11
 * Time: 06:45
 */
@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String state;

    public User(){};

    public User(long id) {
        this.id = id;
    }
}
