package com.sih.sihapi.service;

import java.util.Optional;

import com.sih.sihapi.entities.AadharData;

public interface AadharService {
	public Iterable<AadharData> getAadhar();
	
	public Optional<AadharData> getAadhar(String aadhar);
	
	public Iterable<AadharData> getAadharFirstName(String first_name);
	
	public Iterable<AadharData> getAadharLastName(String last_name);
	
	public Iterable<AadharData> getAadharDob(String dob);
	
	public Iterable<AadharData> getAadharFname(String father_name);
	
	public Iterable<AadharData> getAadharCity(String city);
	
	public Iterable<AadharData> panAndAadharWithSimilarity(String pan);
	
	public Iterable<AadharData> dlAndAadharWithSimilarity(String driving_liscence);
}
