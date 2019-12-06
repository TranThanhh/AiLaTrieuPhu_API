package com.ailatrieuphu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ailatrieuphu.model.CauHoi;

public interface CauHoiRepository extends JpaRepository<CauHoi, Integer> {
	List<CauHoi> findByIdLoaiCH(int idLoaiCH);

	List<CauHoi> findAll();
	
	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	int getLastInsertId();

    int countByIdUser(int idUser);
//
//	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
//	int getLastInsertId();
}
