package com.chamrong.userservice.service;

import com.chamrong.userservice.VO.Department;
import com.chamrong.userservice.VO.ResponseTemplateVO;
import com.chamrong.userservice.entity.User;
import com.chamrong.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  public User saveUser(User user) {
    log.info("Inside saveUser of UserController");
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment of UserController");
    ResponseTemplateVO vo = new ResponseTemplateVO();
    User user = userRepository.findByUserId(userId);
    Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getUserId(), Department.class);

    vo.setUser(user);
    vo.setDepartment(department);

    return vo;
  }
}
