package com.ailatrieuphu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.service.CauHoiService;

@RestController
@RequestMapping("/cauhoi")
public class CauHoiController {
	@Autowired
	private CauHoiService cauHoiService;
	
	@GetMapping("/list2")
	public List<CauHoi> getByIdLoaiCH(@RequestParam int idLoaiCH){
		return cauHoiService.findByIdLoaiCH(idLoaiCH);
	}
}
