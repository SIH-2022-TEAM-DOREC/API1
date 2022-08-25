package com.sih.sihapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dl")
public class DlData {

	@Id
	private String driving_liscence;
	private String firstName;
	private String lastName;
	private String dob;
	private String fatherName;
	private String city;
	
	public DlData() {}
	public DlData(String driving_liscence, String firstName, String lastName, String dob, String fatherName,
			String city) {
		super();
		this.driving_liscence = driving_liscence;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.fatherName = fatherName;
		this.city = city;
	}

	public String getDriving_liscence() {
		return driving_liscence;
	}

	public void setDriving_liscence(String driving_liscence) {
		this.driving_liscence = driving_liscence;
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
