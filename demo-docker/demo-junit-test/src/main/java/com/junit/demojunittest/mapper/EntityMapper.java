package com.junit.demojunittest.mapper;

import com.junit.demojunittest.entity.StudentEntity;
import com.junit.demojunittest.model.Student;

import lombok.Builder;

@Builder

public class EntityMapper {

  public static Student map(StudentEntity studentEntity) {
    return Student.builder() //
        .name(studentEntity.getName()) //
        .age(studentEntity.getAge()) //
        .build(); //
  }
}
