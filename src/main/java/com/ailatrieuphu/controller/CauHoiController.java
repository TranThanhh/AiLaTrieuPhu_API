package com.ailatrieuphu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.service.CauHoiService;

@RestController
@RequestMapping("/cauhoi")
public class CauHoiController {
	@Autowired
	private CauHoiService cauHoiService;
	
	@GetMapping("/list")
	public ResponseEntity<List<CauHoi>> getAllList(){
		List<CauHoi> listCauHoi = cauHoiService.findAll();
		if(listCauHoi.isEmpty()) {
			return new ResponseEntity<List<CauHoi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CauHoi>>(listCauHoi, HttpStatus.OK);
	}
	
	@GetMapping("/list1")
	public List<CauHoi> getAll(){
		return cauHoiService.findAll();
	}
}
