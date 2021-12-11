package com.chamrong.springboot.service;

import com.chamrong.springboot.entity.Department;
import com.chamrong.springboot.error.DepartmentNotFoundException;
import com.chamrong.springboot.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImp(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public List<Department> fetchDepartmentService() {
    return departmentRepository.findAll();
  }

  @Override
  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
    Optional<Department> department = departmentRepository.findById(departmentId);
    if(department.isEmpty()) {
      throw new DepartmentNotFoundException("Department Not Available");
    }

    return department.get();
  }

  @Override
  public void deleteDepartmentById(Long departmentId) {
    departmentRepository.deleteById(departmentId);
  }

  @Override
  public Department updateDepartmentById(Long departmentId, Department department) {
    Department depDB = departmentRepository.findById(departmentId).get();

    if (Objects.nonNull(department.getDepartmentName()) &&
    !"".equalsIgnoreCase(department.getDepartmentName())) {
      depDB.setDepartmentName(department.getDepartmentName());
    }

    if (Objects.nonNull(department.getDepartmentAddress()) &&
    !"".equalsIgnoreCase(department.getDepartmentAddress())) {
      depDB.setDepartmentAddress(department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode()) &&
    !"".equalsIgnoreCase(department.getDepartmentCode())) {
      depDB.setDepartmentCode(department.getDepartmentCode());
    }

    return departmentRepository.save(depDB);
  }

  @Override
  public Department fetchDepartmentByName(String departmentName) {
    return departmentRepository.findBydepartmentNameIgnoreCase(departmentName);
  }

}
