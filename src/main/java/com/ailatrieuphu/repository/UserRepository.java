package com.ailatrieuphu.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ailatrieuphu.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email, String password);
	boolean existsByEmail(String mail);
	boolean existsByNickname(String nickname);
	User findByEmail(String email);

    List<User> findByRoleLevelAndDiemCaoGreaterThan(int roleLevel,int muc, Sort diemCao);

	List<User> findByRoleLevel(int roleLevel);
}
