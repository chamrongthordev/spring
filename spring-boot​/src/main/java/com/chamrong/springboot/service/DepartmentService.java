package com.chamrong.springboot.service;

import com.chamrong.springboot.entity.Department;
import com.chamrong.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
  Department saveDepartment(Department department);

  List<Department> fetchDepartmentService();

  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  void deleteDepartmentById(Long departmentId);

  Department updateDepartmentById(Long departmentId, Department department);

  Department fetchDepartmentByName(String departmentName);
}
