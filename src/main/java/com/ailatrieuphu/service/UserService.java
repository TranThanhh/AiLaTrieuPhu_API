package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ailatrieuphu.model.User;
import com.ailatrieuphu.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //get list user
    public List<User> getAllPlayerActive() {
        return userRepository.findByRoleLevelAndDeletedFalse(0);
    }

    //find user by email and pass to login
    public User findByEmailAndDeletedFalse(String email) {
        return userRepository.findByEmailAndDeletedFalse(email);
    }

    //check exist Nickname
    public boolean existsByNickname(String username) {
        return userRepository.existsByNickname(username);
    }

    //check exist Email
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    //update Password
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updatePassword(User userUpdate) {
        User user = userRepository.findById(userUpdate.getIdUser()).get();
        user.setPassword(userUpdate.getPassword());
        user.setUpdateTime(userUpdate.getUpdateTime());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return false;
        }
    }

    //update Score
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateScore(User userUpdate) {
        User user = userRepository.findById(userUpdate.getIdUser()).get();
        user.setDiemCao(userUpdate.getDiemCao());
        user.setUpdateTime(userUpdate.getUpdateTime());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateRoleLevel(int idUser, int roleLevel, String updateTime) {
        User user = userRepository.findById(idUser).get();
        user.setRoleLevel(roleLevel);
        user.setUpdateTime(updateTime);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteUser(int idUser) {
        User userDelete = userRepository.findById(idUser).get();
        userDelete.setDeleted(true);
        try {
            userRepository.save(userDelete);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<User> getAllModeratorActive() {
        return userRepository.findByRoleLevelAndDeletedFalse(2);
    }

    public List<User> getAllPlayerHighScoreActive() {
        return userRepository.findByRoleLevelAndDiemCaoGreaterThanAndDeletedFalse(0, 0, Sort.by("DiemCao").descending());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int save(User u) {
        try {
            userRepository.save(u);
            User user = userRepository.findByEmailAndPasswordAndDeletedFalse(u.getEmail(), u.getPassword());
            return user.getIdUser();
        } catch (Exception e) {
            return 0;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseEntity<?> fogotPassword(User userForgotPass) {
        User userChangePass = userRepository.findByEmailAndDeletedFalse(userForgotPass.getEmail());
        if (userChangePass == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            userChangePass.setPassword(userForgotPass.getPassword());
            userChangePass.setUpdateTime(userForgotPass.getUpdateTime());
            userRepository.save(userChangePass);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    public String getNickname(int idUser) {
        return userRepository.findById(idUser).get().getNickname();
    }

    public List<User> searchPlayerActive(String keyWord) {
        String email = keyWord;
        String nickname = keyWord;
        String createTime = keyWord;
        String updateTime = keyWord;
        return userRepository.searchPlayerActive(email, nickname, createTime, updateTime);
    }
}
