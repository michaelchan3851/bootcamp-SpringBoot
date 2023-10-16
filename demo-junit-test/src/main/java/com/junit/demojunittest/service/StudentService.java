package com.junit.demojunittest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.junit.demojunittest.mapper.EntityMapper;
import com.junit.demojunittest.model.Student;
import com.junit.demojunittest.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public String getStudentName(String name) {
    //if IAE
    if(name == null)
      throw new IllegalArgumentException();
      System.out.println("Michael Chan");
    //empty
    return this.getDB(); // mock "Mary" // line 16 method
  }

  public String getDB() { // get DB in normal
    return new Student("John", 30).concat("Chan"); // new a student object
  }

  public List<Student> findAll(){
    return studentRepository.findAll().stream() //
      .map(e -> EntityMapper.map(e)) //
      .collect(Collectors.toList());
  }
}
