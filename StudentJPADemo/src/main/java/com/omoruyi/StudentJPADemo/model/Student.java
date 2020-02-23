package com.omoruyi.StudentJPADemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int IDNumber;
	private String SName;
	private String SGrade;
	private String SStatus;	
	private String SHobby;
	
	
	public int getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(int iDNumber) {
		IDNumber = iDNumber;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getSGrade() {
		return SGrade;
	}
	public void setSGrade(String sGrade) {
		SGrade = sGrade;
	}
	public String getSStatus() {
		return SStatus;
	}
	public void setSStatus(String sStatus) {
		SStatus = sStatus;
	}
	public String getSHobby() {
		return SHobby;
	}
	public void setSHobby(String sHobby) {
		SHobby = sHobby;
	}

	@Override
	public String toString() {
		return "Student ID#: " + IDNumber + "\n" +
				"Name: " + SName + "\n" +
				"School Year: " + SGrade + "\n" +
				"Student Status: " + SStatus + "\n" +
				"Hobby: " + SHobby + "\n";
	}
	

}
