package com.junit.demojunittest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.junit.demojunittest.mapper.EntityMapper;
import com.junit.demojunittest.model.Student;
import com.junit.demojunittest.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Value(value = "${api.jmeter.domain}")
  private String domain;

  @Value(value = "${api.jmeter.basePath}")
  private String basePath;

  @Value(value = "${api.jmeter.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  public String getStudentName(String name) {
    // if IAE
    if (name == null)
      throw new IllegalArgumentException();
    System.out.println("Michael Chan");
    // empty
    return this.getDB(); // mock "Mary" // line 16 method
  }

  public String getDB() { // get DB in normal
    return new Student("John", 30).concat("Chan"); // new a student object
  }

  public List<Student> findAll() {
    return studentRepository.findAll().stream() //
        .map(e -> EntityMapper.map(e)) //
        .collect(Collectors.toList());
  }

  public String jmeterTest() {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(domain) //
        .pathSegment(basePath) //
        .path(endpoint) //
        .build() //
        .toUriString();
    System.out.println("demo-junit-test: url=" + url);
    try {
      return restTemplate.getForObject(url, String.class);
    } catch (RestClientException e) {
      System.out.println("error");
      return null;
    }
  }
}
