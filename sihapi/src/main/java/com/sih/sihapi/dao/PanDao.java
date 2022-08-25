package com.sih.sihapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.sih.sihapi.entities.PanData;

public interface PanDao extends CrudRepository<PanData, String>{
	
	public Iterable<PanData> findByDob(String dob);
	
	public Iterable<PanData> findByFatherName(String father_name);
	
	public Iterable<PanData> findByFirstName(String first_name);
	
	public Iterable<PanData> findByLastName(String last_name);
	
	public Iterable<PanData> findByCity(String city);
}
