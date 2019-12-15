package com.ailatrieuphu.service;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.repository.CauHoiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CauHoiService {
    @Autowired
    private CauHoiRepository cauHoiRepository;

    public List<CauHoi> getAllCauHoiActive() {
        return cauHoiRepository.findByDeletedFalse();
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

    public int countCauHoiOfUserActive(int idUser) {
        return cauHoiRepository.countByIdUserAndDeletedFalse(idUser);
    }

    public boolean updateCauHoi(CauHoi cauHoiEdit) {
        try {
            cauHoiRepository.save(cauHoiEdit);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteCauHoi(int idCauHoi) {
        CauHoi cauHoi = cauHoiRepository.findById(idCauHoi).get();
        cauHoi.setDeleted(true);
        try {
            cauHoiRepository.save(cauHoi);
            return true;
        } catch (Exception ex) {
            System.out.println("Lỗi " + ex.getMessage());
            return false;
        }
    }

    public List<CauHoi> searchCauHoiActive(String keyWord) {
        String noiDung = keyWord;
        String createTime = keyWord;
        String updateTime = keyWord;

        return cauHoiRepository.searchCauHoiActive(noiDung, createTime, updateTime);
    }
}
