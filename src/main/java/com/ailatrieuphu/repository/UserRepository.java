package com.ailatrieuphu.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ailatrieuphu.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPasswordAndDeletedFalse(String email, String password);

    boolean existsByEmail(String mail);

    boolean existsByNickname(String nickname);

    User findByEmailAndDeletedFalse(String email);

    List<User> findByRoleLevelAndDiemCaoGreaterThanAndDeletedFalse(int roleLevel, int muc, Sort diemCao);

    List<User> findByRoleLevelAndDeletedFalse(int roleLevel);

    @Query(value = "SELECT * FROM (SELECT * FROM user WHERE IsDeleted=false AND RoleLevel=0) as player " +
            "WHERE Email LIKE %?1% OR Nickname LIKE %?2% OR CreateTime LIKE %?3% OR UpdateTime LIKE %?4%",nativeQuery = true)
    List<User> searchPlayerActive(String email, String nickname, String createTime, String updateTime);
}
