package com.junit.demojunittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.demojunittest.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
