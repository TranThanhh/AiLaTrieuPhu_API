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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ailatrieuphu.model.CauHoi;
import com.ailatrieuphu.model.User;
import com.ailatrieuphu.service.CauHoiService;
import com.ailatrieuphu.service.UserService;

@RestController
public class AdminController {
    @Autowired
    private CauHoiService cauHoiService;
    @Autowired
    private UserService userService;

    //--------------------------------------------------CAUHOI-------------------------------------
    @GetMapping("/admin/cauhois")
    public ResponseEntity<List<CauHoi>> getAllCauHoiActive() {
        List<CauHoi> cauHoiList = cauHoiService.getAllCauHoiActive();
        if (cauHoiList.isEmpty()) {
            return new ResponseEntity<List<CauHoi>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CauHoi>>(cauHoiList, HttpStatus.OK);
    }

    // add CauHoi new.
    @PostMapping("/admin/cauhois")
    public String addCauHoi(@RequestBody CauHoi cauHoiNew) {
        if (cauHoiService.addCauHoi(cauHoiNew) == true)
            return "success";
        else
            return "fail";
    }

    // edit cauhoi.
    @PutMapping("/admin/cauhois")
    public String updateCauHoi(@RequestBody CauHoi cauHoiEdit) {
        if (cauHoiService.updateCauHoi(cauHoiEdit) == true)
            return "success";
        else return "fail";
    }

    //delete cauhoi.
    @DeleteMapping("/admin/cauhois")
    public String deleteCauHoi(@RequestParam int idCauHoi){
        if(cauHoiService.deleteCauHoi(idCauHoi)==true) return "success";
        else return "fail";
    }

    //--------------------------------------------------USER-------------------------------------
    // get list user
    @GetMapping("/admin/users-player")
    public ResponseEntity<List<User>> getAllPlayer() {
        List<User> playerList = userService.getAllPlayer();
        if (playerList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(playerList, HttpStatus.OK);
    }

    //get list all moderator.
    @GetMapping("/admin/users-moderator")
    public ResponseEntity<List<User>> getAllModerator() {
        List<User> moderatorList = userService.getAllModerator();
        if (moderatorList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(moderatorList, HttpStatus.OK);
    }

    //Set AdminRole.
    @PutMapping("/admin/users/role-level")
    public String updateRoleLevel(@RequestParam int idUser, int roleLevel, String updateTime) {
        if (userService.updateRoleLevel(idUser, roleLevel, updateTime)) {
            return "success";
        } else {
            return "fail";
        }
    }

    //Delete user.
    @DeleteMapping("/admin/users")
    public String deleteUser(@RequestParam int idUser) {
        if (userService.deleteUser(idUser)) {
            return "success";
        } else return "fail";
    }

    //cout cauhois of user.
    @PostMapping("/admin/users/size-of-cauhoi")
    public int countCauHoiOfUser(int idUser) {
        return cauHoiService.countCauHoiOfUser(idUser);
    }
}
