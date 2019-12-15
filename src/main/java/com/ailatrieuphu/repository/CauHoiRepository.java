package com.ailatrieuphu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ailatrieuphu.model.CauHoi;

public interface CauHoiRepository extends JpaRepository<CauHoi, Integer> {

    List<CauHoi> findByDeletedFalse();

    List<CauHoi> findByIdLoaiCHAndDeletedFalse(int idLoaiCH);

    int countByIdUserAndDeletedFalse(int idUser);

    @Query(value = "SELECT * FROM (SELECT * FROM cauhoi WHERE IsDeleted=false) AS cauhoitemp " +
            "WHERE NoiDung LIKE %?1% OR CreateTime LIKE %?2% OR UpdateTime LIKE %?3%",nativeQuery = true)
    List<CauHoi> searchCauHoiActive(String noiDung, String createTime, String updateTime);
}
