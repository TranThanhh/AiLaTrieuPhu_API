package com.ailatrieuphu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.User;
import com.ailatrieuphu.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // check info before Register
    @PostMapping("/users-check")
    public String checkUser(@RequestBody User u) {
        if (userService.existsByEmail(u.getEmail())) {
            return "email";
        }
        if (userService.existsByNickname(u.getNickname())) {
            return "nickname";
        }

        return "no";
    }

    // member Register success
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @PostMapping("/users")
    public int insertUser(@RequestBody User u) {
        try {
            userService.save(u);
            User user = userService.findByEmailAndPassword(u.getEmail(), u.getPassword());
            return user.getIdUser();
        } catch (Exception e) {
            return 0;
        }
    }

    // Login
    @PostMapping("/users-login")
    public ResponseEntity<User> getUserByEmailAndPassword(@RequestBody User u) {
        User user = userService.findByEmailAndPassword(u.getEmail(), u.getPassword());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    // Change pass
    @PutMapping("/users/password")
    public String updatePassword(@RequestBody User userChangePass) {
        if (userService.updatePassword(userChangePass) == true) {
            return "success";
        } else {
            return "failed";
        }

    }
    //Forgot Pass
    @PutMapping("/users/newpassword")
	public ResponseEntity<?> forgotPassword(@RequestBody User userForgotPass) {
		User userChangePass = userService.findByEmail(userForgotPass.getEmail());
		if (userChangePass == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userChangePass.setPassword(userForgotPass.getPassword());
			userChangePass.setUpdateTime(userForgotPass.getUpdateTime());
			userService.save(userChangePass);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}


    // Modify score
    @PutMapping("/users/score")
    public String updateScore(@RequestBody User userModifyScore) {
        if (userService.updateScore(userModifyScore) == true) {
            return "success";
        } else {
            return "failed";
        }

    }

    //get list highscore
    @GetMapping("/users/high-score")
    public ResponseEntity<List<User>> getAllPlayerHighScore() {
        List<User> playerHighScoreList = userService.getAllPlayerHighScore();
        if (playerHighScoreList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(playerHighScoreList, HttpStatus.OK);
    }
}
