package com.ailatrieuphu.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.User;
import com.ailatrieuphu.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //get list highscore
    @GetMapping("/users/high-score")
    public ResponseEntity<List<User>> getAllPlayerHighScoreActive() {
        List<User> playerHighScoreList = userService.getAllPlayerHighScoreActive();
        if (playerHighScoreList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(playerHighScoreList, HttpStatus.OK);
    }

    //get author of cauhoi.
    @GetMapping("/users/nickname")
    public String getNickname(@RequestParam int idUser) {
        return userService.getNickname(idUser);
    }

    // check info before Register
    @PostMapping("/users-check")
    public String checkUserExists(@RequestBody User u) {
        if (userService.existsByEmail(u.getEmail())) {
            return "email";
        }
        if (userService.existsByNickname(u.getNickname())) {
            return "nickname";
        }

        return "no";
    }

    // member Register success
    @PostMapping("/users")
    public int insertUser(@RequestBody User u) {
        return userService.save(u);
    }

    // Login
    @PostMapping("/users-login")
    public ResponseEntity<User> getUserLogin(@RequestBody User u) {
        User user = userService.findByEmailAndDeletedFalse(u.getEmail());
        if (user != null){
            if(BCrypt.checkpw(u.getPassword(),user.getPassword())) return new ResponseEntity<User>(user, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
        return userService.fogotPassword(userForgotPass);
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
}
