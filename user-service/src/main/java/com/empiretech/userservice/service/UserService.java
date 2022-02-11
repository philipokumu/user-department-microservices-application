package com.empiretech.userservice.service;

import com.empiretech.userservice.VO.ResponseTemplateVO;
import com.empiretech.userservice.entity.Department;
import com.empiretech.userservice.entity.User;
import com.empiretech.userservice.repository.UserRepository;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private User defaultUser;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @CircuitBreaker(name = "departmentCircuitBreaker", fallbackMethod = "fallback")
    public ResponseTemplateVO getUserWithDepartment(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);
        this.defaultUser = user;
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

    public ResponseTemplateVO fallback(Exception e) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Department department = new Department(1L, "IT","default Street","IT-407");
        vo.setUser(defaultUser);
        vo.setDepartment(department);
        return vo;
    }
    
}
