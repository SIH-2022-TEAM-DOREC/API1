package com.sih.sihapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.sih.sihapi.entities.DlData;

public interface DlDao extends CrudRepository<DlData, String>{

	public Iterable<DlData> findByDob(String dob);
	
	public Iterable<DlData> findByFirstName(String first_name);
	
	public Iterable<DlData> findByLastName(String last_name);
	
	public Iterable<DlData> findByFatherName(String father_name);
	
	public Iterable<DlData> findByCity(String city);
}
