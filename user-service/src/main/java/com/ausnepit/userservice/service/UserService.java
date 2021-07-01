package com.ausnepit.userservice.service;

import com.ausnepit.userservice.dto.ResponseTemplate;
import com.ausnepit.userservice.entity.User;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.userservice.service
 * project-name: user-service
 */
public interface UserService {

    User saveUser(User user);

    ResponseTemplate getUserByIdWithDepartment(Long userId);
}
