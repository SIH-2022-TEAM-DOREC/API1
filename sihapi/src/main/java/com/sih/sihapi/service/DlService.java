package com.sih.sihapi.service;

import java.util.Optional;

import com.sih.sihapi.entities.DlData;

public interface DlService {
	
	public Iterable<DlData> getDl();
	
	public Optional<DlData> getDl(String pan);
	
	public Iterable<DlData> getDlFirstName(String first_name);
	
	public Iterable<DlData> getDlLastName(String last_name);
	
	public Iterable<DlData> getDlDob(String dob);
	
	public Iterable<DlData> getDlFname(String father_name);
	
	public Iterable<DlData> getDlCity(String city);
	
	public Iterable<DlData> aadharAndDlWithSimilarity(String aadhar);
	
	public Iterable<DlData> panAndDlWithSimilarity(String pan);
}
