package com.ausnepit.userservice.service;

import com.ausnepit.userservice.dto.Department;
import com.ausnepit.userservice.dto.ResponseTemplate;
import com.ausnepit.userservice.entity.User;
import com.ausnepit.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.userservice.service
 * project-name: user-service
 */
@Service
@Slf4j
public class UserServiceImpl  implements UserService{

    private UserRepository userRepository;
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public User saveUser(User user) {
        log.info("Inside save user of UserServiceImpl::{}",user);
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplate getUserByIdWithDepartment(Long userId) {
        ResponseTemplate response = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/get-by-id/"+user.getDepartmentId(),Department.class);
        response.setDepartment(department);
        response.setUser(user);
        return response;
    }
}