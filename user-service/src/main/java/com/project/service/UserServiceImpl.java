package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

//	@Override
//	public User search(Long userId) {
//		// TODO Auto-generated method stub
//		return userRepository.findById(userId).orElse(null);
//	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User search(Long userId) {
		// TODO Auto-generated method stub
		
		//just testing 2
		return userRepository.findById(userId).orElse(null);
	}



}
