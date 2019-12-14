package com.ailatrieuphu.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ailatrieuphu.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPasswordAndDeletedFalse(String email, String password);

    boolean existsByEmail(String mail);

    boolean existsByNickname(String nickname);

    User findByEmailAndDeletedFalse(String email);

    List<User> findByRoleLevelAndDiemCaoGreaterThanAndDeletedFalse(int roleLevel, int muc, Sort diemCao);

    List<User> findByRoleLevelAndDeletedFalse(int roleLevel);
}
