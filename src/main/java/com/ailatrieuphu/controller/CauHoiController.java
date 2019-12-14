package com.ailatrieuphu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.service.CauHoiService;
import com.ailatrieuphu.service.UserService;

@RestController
public class CauHoiController {
	@Autowired
	private CauHoiService cauHoiService;
	
	@GetMapping("/cauhois/loai")
	public List<CauHoi> getByIdLoaiCHActive(@RequestParam int idLoaiCH){
		return cauHoiService.findByIdLoaiCHAndDeletedFalse(idLoaiCH);
	}
}
