package com.ailatrieuphu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.model.Choi;
import com.ailatrieuphu.repository.CauHoiRepository;
import com.ailatrieuphu.repository.ChoiRepository;

@Service
public class CauHoiService {
    @Autowired
    private CauHoiRepository cauHoiRepository;
    @Autowired
    private ChoiRepository choiRepository;

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
        Choi choi=new Choi();
        choi.setIdUser(1);
        choi.setIdCauHoi(idCauHoi);
        try {
            //cauHoiRepository.deleteById(idCauHoi);
            choiRepository.save(choi);
            return true;
        } catch (Exception ex){
            return false;
        }
	}
}
