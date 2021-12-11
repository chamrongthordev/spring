package com.chamrong.springboot.service;

import com.chamrong.springboot.entity.Department;
import com.chamrong.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department =
        Department.builder()
            .departmentName("IT")
            .departmentAddress("Phnom Penh")
            .departmentCode("IT-006")
            .departmentId(1L)
            .build();

    Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT"))
        .thenReturn(department);
  }

  @Test
  @DisplayName("Get Data based on Valida Department Name")
  @Disabled
  void whenValidDepartmentName_thenDepartmentShouldFound() {
    String departmentName = "IT";
    Department found = departmentService.fetchDepartmentByName(departmentName);

    assertEquals(departmentName, found.getDepartmentName());
  }
}