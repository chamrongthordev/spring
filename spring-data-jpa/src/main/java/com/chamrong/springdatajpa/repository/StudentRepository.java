package com.chamrong.springdatajpa.repository;

import com.chamrong.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByFirstName(String firstName);
  List<Student> findByFirstNameContaining(String name);
  List<Student> findByLastNameNotNull();
  List<Student> findByGuardianName(String guardianName);
  Student findByFirstNameAndLastName(String firstName, String lastName);
}
