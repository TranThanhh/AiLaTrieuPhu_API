//package com.ailatrieuphu.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ailatrieuphu.model.Diem;
//import com.ailatrieuphu.service.DiemService;
//
//@RestController
//@RequestMapping("/diem")
//public class DiemController {
//	@Autowired
//	private DiemService diemService;
//	@GetMapping("/diemcao")
//	public int getScoreByIdUser(@RequestParam int idUser){
//		try {
//			return diemService.findByidUser(idUser);
//		}catch (Exception e) {
//			return 0;
//		}
//		
//	}
//	@PostMapping("/setScore")
//	public String setScore(@RequestBody Diem diem) {
//		try {
//			diemService.save(diem);
//			return "success";
//		} catch (Exception e) {
//			return "fail";
//		}
//	}
//	@PutMapping("/modifyScore")
//	public String modifyScore(@RequestBody Diem diem) {
//		try {
//			diemService.save(diem);
//			return "success";
//		} catch (Exception e) {
//			return "fail";
//		}
//	}
//}
