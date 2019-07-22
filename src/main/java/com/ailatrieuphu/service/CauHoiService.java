package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.repository.CauHoiRepository;

@Service
public class CauHoiService {
	@Autowired
	private CauHoiRepository cauHoiRespository;
	
	public List<CauHoi> findAll(){
		return cauHoiRespository.findAll();
	}
}
