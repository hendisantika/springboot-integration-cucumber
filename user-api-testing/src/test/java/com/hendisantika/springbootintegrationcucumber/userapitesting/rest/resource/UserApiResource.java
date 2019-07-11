package com.hendisantika.springbootintegrationcucumber.userapitesting.rest.resource;

import com.hendisantika.springbootintegrationcucumber.userapitesting.config.ApplicationProperties;
import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.dto.UserDto;
import com.hendisantika.springbootintegrationcucumber.userapitesting.rest.helper.RestHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integration-cucumber
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-12
 * Time: 05:41
 */
@Slf4j
public class UserApiResource {

    private String resourceUrl;

    public UserApiResource(ApplicationProperties applicationProperties) {
        this.resourceUrl = applicationProperties.getProperty("user.api.url");
    }

    public List<UserDto> getUsers(String path, String userId) {
        String resourceUrl = this.resourceUrl + path;
        try {
            RestTemplate restTemplate = RestHelper.getRestTemplate();
            HttpHeaders headers = RestHelper.getHeaders();
            HttpEntity entity = new HttpEntity(headers);

            List<UserDto> userDtos = new ArrayList<>();
            if (userId != null) {
                /*UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resourceUrl)
                        .queryParam("userId", userId);
                resourceUrl = builder.toUriString();*/
                resourceUrl = resourceUrl + "/" + Long.valueOf(userId);
                HttpEntity<UserDto> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, UserDto.class);
                UserDto userDto = usersTemp.getBody();
                userDtos.add(userDto);
            } else {
                HttpEntity<List<UserDto>> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<UserDto>>() {
                });
                userDtos = usersTemp.getBody();
            }
            return userDtos;
        } catch (Exception e) {
            log.error("Error occured in UserApiResource.getUsers", e.getMessage());
            throw new RuntimeException("Exception in UserApiResource.getUsers", e);
        }
    }

    public void postUsers(UserDto userDto) {
        String resourceUrl = this.resourceUrl + "/";
        try {
            RestTemplate restTemplate = RestHelper.getRestTemplate();
            HttpHeaders headers = RestHelper.getHeaders();
            HttpEntity<UserDto> entity = new HttpEntity(userDto, headers);
            HttpEntity<String> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.POST, entity, String.class);

        } catch (Exception e) {
            log.error("Error occured in UserApiResource.postUsers", e.getMessage());
            throw new RuntimeException("Exception in UserApiResource.postUsers", e);
        }
    }

    public void deleteAddedUser() {
        String resourceUrl = this.resourceUrl + "/";
        RestTemplate restTemplate = RestHelper.getRestTemplate();
        HttpHeaders headers = RestHelper.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        HttpEntity<String> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.DELETE, entity, String.class);
    }
}