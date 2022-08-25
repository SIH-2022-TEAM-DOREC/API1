package com.sih.sihapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.sih.sihapi.entities.AadharData;

public interface AadharDao extends CrudRepository<AadharData, String>{
	
	public Iterable<AadharData> findByDob(String dob);
	
	public Iterable<AadharData> findByFatherName(String father_name);
	
	public Iterable<AadharData> findByFirstName(String first_name);
	
	public Iterable<AadharData> findByLastName(String last_name);
	
	public Iterable<AadharData> findByCity(String city);
}
