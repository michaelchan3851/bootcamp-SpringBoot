package com.bootcamp.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.infra.Protocol;
import com.bootcamp.demo.model.User;
import com.bootcamp.demo.service.UserService;

@Service
public class UserServiceimpl implements UserService { // Bean -> dependency

  @Autowired
  private RestTemplate restTemplate; // from Context

  @Value(value = "${api.jsonplaceholder.domain}")
  private String jphDomain; // jsonplaceholder.typicode.com // from yml

  @Value(value = "${api.jsonplaceholder.endpoints.users}")
  private String userEndpoint; // users from yml

  @Override
  public List<User> findUsers() {

    String url = UriComponentsBuilder.newInstance() // static builder
        .scheme(Protocol.HTTPS.name()) // https
        .host(jphDomain) // www.jsonplaceholder.typicode.com
        .path(userEndpoint) //
        .toUriString();

    System.out.println("url=" + url);
    // Invoke API + Deserialization (JSON -> Object)
    try {
      User[] users = restTemplate.getForObject(url, User[].class); // return type = User[].class
      return Arrays.asList(users);
    } catch (RestClientException e) {
      return null;
    }

  }

  @Override
  public User findById(Long id) {
    return findUsers().stream()
        .filter(e -> e.getId() == id)
        .findFirst()
        .get();
  }
}
