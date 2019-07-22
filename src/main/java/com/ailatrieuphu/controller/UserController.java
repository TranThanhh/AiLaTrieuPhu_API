package com.ailatrieuphu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.User;
import com.ailatrieuphu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//get list user
	@GetMapping("/listUser")
	public List<User> getAll(){
		return userService.findAll();
	}
	//check info before Register
	@PostMapping("/check")
	public String checkUser(@RequestBody User u) {
		if(userService.existsByEmail(u.getEmail())) {
			return "email";
		}
		if(userService.existsByNickname(u.getNickname())) {
			return "nickname";
		}
		
		return "no";
	}
	
	//member Register success
	@PostMapping("/addUser")
	public String insertUser(@RequestBody User u) {
		try {
			userService.save(u);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}
	//Login
	@PostMapping("/login")
	public ResponseEntity<User> getUserByEmailAndPassword(@RequestBody User u){
		User user=userService.findByEmailAndPassword(u.getEmail(),u.getPassword());
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	//Change pass
		@PutMapping("/changePass")
		public String updatePassword(@RequestBody User userChangePass) {
			if(userService.updatePassword(userChangePass)==true) {
				return "success";
			}
			else {
				return "failed";
			}
			
		}
}
