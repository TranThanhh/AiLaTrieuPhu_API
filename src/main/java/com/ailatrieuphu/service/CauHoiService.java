package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.repository.CauHoiRepository;

@Service
public class CauHoiService {
	@Autowired
	private CauHoiRepository cauHoiRepository;

	public List<CauHoi> getAllCauHoi() {
		return cauHoiRepository.findAll();
	}

	public List<CauHoi> findByIdLoaiCH(int idLoaiCH) {
		return cauHoiRepository.findByIdLoaiCH(idLoaiCH);
	}
	//add new question
	public boolean addCauHoi(CauHoi cauHoiNew) {
		try {
			cauHoiRepository.save(cauHoiNew);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
