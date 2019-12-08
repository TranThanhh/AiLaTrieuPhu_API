package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<User> getAllPlayer() {
        return userRepository.findByRoleLevel(0);
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
    public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

    //update Password
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

    public boolean deleteUser(int idUser) {
        try {
            userRepository.deleteById(idUser);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<User> getAllModerator() {
        return userRepository.findByRoleLevel(2);
    }

    public List<User> getAllPlayerHighScore() {
        return userRepository.findByRoleLevelAndDiemCaoGreaterThan(0,0, Sort.by("DiemCao").descending());
    }
}
