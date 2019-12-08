package com.ailatrieuphu.service;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.repository.CauHoiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CauHoiService {
    @Autowired
    private CauHoiRepository cauHoiRepository;

    public List<CauHoi> getAllCauHoiActive() {
        return cauHoiRepository.findByDeletedFalse();
    }

    public List<CauHoi> findByIdLoaiCH(int idLoaiCH) {
        return cauHoiRepository.findByIdLoaiCH(idLoaiCH);
    }
    
    public List<CauHoi> findByIdLoaiCHAndDeletedFalse(int idLoaiCH) {
        return cauHoiRepository.findByIdLoaiCHAndDeletedFalse(idLoaiCH);
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

    public int countCauHoiOfUser(int idUser) {
        return cauHoiRepository.countByIdUser(idUser);
    }

    public boolean updateCauHoi(CauHoi cauHoiEdit) {
		try {
			cauHoiRepository.save(cauHoiEdit);
			return true;
		} catch (Exception ex) {
			return false;
		}
    }

	public boolean deleteCauHoi(int idCauHoi) {
        CauHoi cauHoi=cauHoiRepository.findById(idCauHoi).get();
        cauHoi.setDeleted(true);
        try {
            cauHoiRepository.save(cauHoi);
            return true;
        } catch (Exception ex){
            System.out.println("Lỗi "+ex.getMessage());
            return false;
        }
	}
}
