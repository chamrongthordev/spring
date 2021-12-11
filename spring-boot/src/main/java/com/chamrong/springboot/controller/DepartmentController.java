package com.chamrong.springboot.controller;

import com.chamrong.springboot.entity.Department;
import com.chamrong.springboot.error.DepartmentNotFoundException;
import com.chamrong.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
  private final DepartmentService departmentService;

  private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {
    logger.info("Inside saveDepartment of DepartmentController");
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {
    logger.info("Inside fetchDepartmentList of DepartmentController");
    return departmentService.fetchDepartmentService();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
    logger.info("Inside fetchDepartmentById of DepartmentController");
    return departmentService.fetchDepartmentById(departmentId);
  }

  @DeleteMapping("/departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
    departmentService.deleteDepartmentById(departmentId);
    logger.info("Inside deleteDepartmentById of DepartmentController");
    return "Department deleted successfully!!!";
  }

  @PutMapping("/departments/{id}")
  public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
    logger.info("Inside updateDepartmentById of DepartmentController");
    return departmentService.updateDepartmentById(departmentId, department);
  }

  @GetMapping("/departments/name/{name}")
  public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
    logger.info("Inside fetchDepartmentByName of DepartmentController");
    return departmentService.fetchDepartmentByName(departmentName);
  }

}
