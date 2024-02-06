package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.LoginDto;
import com.project.entity.User;
import com.project.exception.IdNotPresentException;
import com.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		try {
			User user1 = userService.addOrUpdateUser(user);
			return ResponseEntity.ok().body(user1);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody User user) {
		try {
			User user1 = userService.addOrUpdateUser(user);
			return ResponseEntity.ok().body(user1);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		try {
			User user = userService.login(loginDto.getEmail(), loginDto.getPassword());
			if (user != null)
				return ResponseEntity.ok().body(user);
			else
				throw new IdNotPresentException("wrong credentials");

		} catch (IdNotPresentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
