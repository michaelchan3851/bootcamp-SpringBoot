package com.junit.demojunittest.model;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
// import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.junit.demojunittest.entity.StudentEntity;
import com.junit.demojunittest.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {
  
  @Autowired
  private StudentRepository studentRepository;

  @Autowired 
  private TestEntityManager entityManager;

  @Test
  void testFindAll(){
    // save (entityManager)
    StudentEntity s1 = new StudentEntity("ABC", 30);
    StudentEntity s2 = new StudentEntity("XYZ", 20);
    entityManager.persist(s1);
    entityManager.persist(s2);
    // List<StudentEntity> students = List.of(s1, s2, s3);
    

    //findAll
    List<StudentEntity> studentEntities = studentRepository.findAll();
    assertThat(studentEntities.size(), equalTo(2));
    assertThat(studentEntities, hasItem(hasProperty("id", equalTo(1L))));
    assertThat(studentEntities, hasItem(hasProperty("name", equalTo("XYZ"))));
    assertThat(studentEntities, hasItem(hasProperty("age", equalTo(20))));
  }
}
