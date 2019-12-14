package com.ailatrieuphu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ailatrieuphu.model.CauHoi;

public interface CauHoiRepository extends JpaRepository<CauHoi, Integer> {

    List<CauHoi> findByDeletedFalse();

    List<CauHoi> findByIdLoaiCHAndDeletedFalse(int idLoaiCH);

    int countByIdUserAndDeletedFalse(int idUser);
}
