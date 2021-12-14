package com.chamrong.springdatajpa.repository;

import com.chamrong.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student = Student.builder()
        .emailId("chamrong@gmail.com")
        .firstName("Chamrong")
        .lastName("Thor")
        .guardianName("Ran")
        .guardianEmail("ran@gmail.com")
        .guardianMobile("123456789")
        .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudents() {
    List<Student> studentList = studentRepository.findAll();
    System.out.println("studentList" + studentList);
  }
}