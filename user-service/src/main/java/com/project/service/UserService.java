package com.project.service;

import com.project.entity.User;

public interface UserService {
User addOrUpdateUser(User user);
User login(String email,String password);
User search(Long userId);
}
