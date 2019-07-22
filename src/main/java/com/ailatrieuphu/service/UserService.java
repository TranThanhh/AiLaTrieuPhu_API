package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailatrieuphu.model.User;
import com.ailatrieuphu.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	//get list user
	public List<User> findAll(){
		return userRepository.findAll();
	}
	//find user by email and pass to login
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	//check exist Nickname
	public boolean existsByNickname(String username) {
		return userRepository.existsByNickname(username);
	}
	//check exist Email
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	//Save user
	public void save(User u) {
		userRepository.save(u);
	}
	//update Password
	public boolean updatePassword(User userUpdate) {
		User user = userRepository.findById(userUpdate.getIdUser()).get();
		user.setPassword(userUpdate.getPassword());
		try {
			userRepository.save(user);
			return true;
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
			return false;
		}
	}
}
