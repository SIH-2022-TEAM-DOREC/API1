package com.sih.sihapi.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aadhar")
public class AadharData {
	
	@Id
	private String aadhar;
	private String firstName;
	private String lastName;
	private String dob;
	private String fatherName;
	private String city;
	
	public AadharData() {}
	
	public AadharData(String aadhar, String firstName, String lastName, String dob, String fatherName, String city) {
		this.aadhar = aadhar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.fatherName = fatherName;
		this.city = city;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
