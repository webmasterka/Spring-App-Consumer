package com.springappconsumer.services;

import com.springappconsumer.Config;
import com.springappconsumer.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateUserService implements UserService{
    private final RestTemplate restTemplate;

    public RestTemplateUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User showUser(Long id) {
        return restTemplate.getForObject(Config.BASE_URL + "/" + id, User.class);
    }

    @Override
    public void addUser(User user) {
        restTemplate.postForEntity(Config.BASE_URL, user, User.class);
    }

    @Override
    public void removeUser(Long id) {
        restTemplate.delete(Config.BASE_URL + "/" + id);
    }

    @Override
    public List<User> getUsers() {
        return restTemplate.exchange(
                Config.BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        ).getBody();
    }
}

