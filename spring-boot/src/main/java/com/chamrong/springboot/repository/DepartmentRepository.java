package com.chamrong.springboot.repository;

import com.chamrong.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  public Department findBydepartmentName(String departmentName);
  public Department findBydepartmentNameIgnoreCase(String departmentName);
}
