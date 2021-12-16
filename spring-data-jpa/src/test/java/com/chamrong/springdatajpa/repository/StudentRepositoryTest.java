package com.chamrong.springdatajpa.repository;

import com.chamrong.springdatajpa.entity.Guardian;
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
  void saveStudent() {
    Student student = Student.builder()
        .emailId("chamrong@gmail.com")
        .firstName("Chamrong")
        .lastName("Thor")
//        .guardianName("Ran")
//        .guardianEmail("ran@gmail.com")
//        .guardianMobile("123456789")
        .build();

    studentRepository.save(student);
  }

  @Test
  void saveStudentWithGuardian() {
    Guardian guardian = Guardian.builder()
        .name("check")
        .email("check@gmail.com")
        .mobile("123456789")
        .build();
    Student student = Student.builder()
        .firstName("Chamrong")
        .emailId("lam@gmail.com")
        .lastName("Thor")
        .guardian(guardian)
        .build();

    studentRepository.save(student);
  }

  @Test
  void printAllStudents() {
    List<Student> studentList = studentRepository.findAll();
    System.out.println("studentList" + studentList);
  }

  @Test
  void printStudentByFirstName() {
    List<Student> students = studentRepository.findByFirstName("Chamrong");
    System.out.println("Students = " + students);
  }

  @Test
  void printStudentByFirstNameContaining() {
    List<Student> students = studentRepository.findByFirstNameContaining("rong");
    System.out.println("Students = " + students);
  }

  @Test
  void printStudentBasedOnGuardianName() {
    List<Student> students = studentRepository.findByGuardianName("ran");
    System.out.println("students = " + students);
  }
}