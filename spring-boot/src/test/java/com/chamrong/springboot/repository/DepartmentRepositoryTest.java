package com.chamrong.springboot.repository;

import com.chamrong.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private TestEntityManager entityManager;

  @BeforeEach
  void setUp() {
    Department department =
        Department.builder()
            .departmentName("Information Technology")
            .departmentCode("IT-001")
            .departmentAddress("PHNOM PENH")
            .build();

    entityManager.persist(department);
  }

  @Test
  void whenFindById_thenReturnDepartment() {
    Department department = departmentRepository.findById(1L).get();
    assertEquals("Information Technology", department.getDepartmentName());
  }
}