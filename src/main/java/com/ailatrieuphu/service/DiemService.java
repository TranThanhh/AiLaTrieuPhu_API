//package com.ailatrieuphu.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ailatrieuphu.model.Diem;
//import com.ailatrieuphu.repository.DiemRepository;
//
//@Service
//public class DiemService {
//	@Autowired
//	private DiemRepository diemRepository;
//	
//	//get score user by id
//	public int findByidUser(int idUser) {
//		return diemRepository.findByidUser(idUser).getDiemCao();
//	}
//	//Save score
//	public void save(Diem diem) {
//		System.out.println(diem.getDiemCao()+"");
//		diemRepository.save(diem);
//	}
//
//}
