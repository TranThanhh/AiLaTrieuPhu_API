package com.ailatrieuphu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cauhoi")
public class CauHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCauHoi")
	private int idCauHoi;
	@Column(name = "NoiDung")
	private String noiDung;
	@Column(name = "CauA")
	private String cauA;
	@Column(name = "CauB")
	private String cauB;
	@Column(name = "CauC")
	private String cauC;
	@Column(name = "CauD")
	private String cauD;
	@Column(name = "idloaiCH")
	private int idLoaiCH;
	@Column(name = "idUser")
	private int idUser;
	@Column(name="CreatedTime")
	private String createdTime;
	@Column(name="UpdateTime")
    private String updateTime;
	@Column(name="DapAnDung")	
	private String dapAnDung;
	
	public int getIdCauHoi() {
		return idCauHoi;
	}
	public void setIdCauHoi(int idCauHoi) {
		this.idCauHoi = idCauHoi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getCauA() {
		return cauA;
	}
	public void setCauA(String cauA) {
		this.cauA = cauA;
	}
	public String getCauB() {
		return cauB;
	}
	public void setCauB(String cauB) {
		this.cauB = cauB;
	}
	public String getCauC() {
		return cauC;
	}
	public void setCauC(String cauC) {
		this.cauC = cauC;
	}
	public String getCauD() {
		return cauD;
	}
	public void setCauD(String cauD) {
		this.cauD = cauD;
	}
	public int getIdLoaiCH() {
		return idLoaiCH;
	}
	public void setIdLoaiCH(int idLoaiCH) {
		this.idLoaiCH = idLoaiCH;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDapAnDung() {
		return dapAnDung;
	}
	public void setDapAnDung(String dapAnDung) {
		this.dapAnDung = dapAnDung;
	}
	
}
