package com.sih.sihapi.service;

import java.util.Optional;

import com.sih.sihapi.entities.PanData;

public interface PanService {
	public Iterable<PanData> getPan();
	
	public Optional<PanData> getPan(String pan);
	
	public Iterable<PanData> getPanFirstName(String first_name);
	
	public Iterable<PanData> getPanLastName(String last_name);
	
	public Iterable<PanData> getPanDob(String dob);
	
	public Iterable<PanData> getPanFatherName(String father_name);
	
	public Iterable<PanData> getPanCity(String city);
	
	public Iterable<PanData> aadharAndPanWithSimilarity(String aadhar);
	
	public Iterable<PanData> dlAndPanWithSimilarity(String driving_liscence);
}
