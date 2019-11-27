package com.ailatrieuphu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.model.User;
import com.ailatrieuphu.service.CauHoiService;
import com.ailatrieuphu.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CauHoiService cauHoiService;
	@Autowired
	private UserService userService;

//--------------------------------------------------CAUHOI-------------------------------------
	@GetMapping("/cauhoi/all/list")
	public ResponseEntity<List<CauHoi>> getAllCauHoi() {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoi();
		if (listCauHoi.isEmpty()) {
			return new ResponseEntity<List<CauHoi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CauHoi>>(listCauHoi, HttpStatus.OK);
	}

	// add CauHoi new.
	@PostMapping("/cauhoi/one")
	public String addCauHoi(@RequestBody CauHoi cauHoiNew) {
		if (cauHoiService.addCauHoi(cauHoiNew) == true)
			return "success";
		else
			return "fail";
	}
//--------------------------------------------------USER-------------------------------------
	// get list user
	@GetMapping("/user/all/list")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUser = userService.getAllUser();
		if (listUser.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}

	//Set AdminRole.
	@PutMapping("/user/one/adminrole")
	public String updateAdminRole(@RequestParam int idUser, String updateTime){
		if(userService.updateAdminRole(idUser, updateTime)){
			return "success";
		} else {
			return "fail";
		}
	}

	//Delete user.
	@DeleteMapping("user/one")
	public String deleteUser(@RequestParam int idUser){
		if(userService.deleteUser(idUser)){
			return "success";
		} else return "fail";
	}
}
