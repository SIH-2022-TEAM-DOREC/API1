package com.sih.sihapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sih.sihapi.dao.AadharDao;
import com.sih.sihapi.dao.DlDao;
import com.sih.sihapi.dao.PanDao;
import com.sih.sihapi.entities.AadharData;
import com.sih.sihapi.entities.DlData;
import com.sih.sihapi.entities.PanData;

@Service
public class AadharServiceIm implements AadharService {
	
	@Autowired
	private AadharDao aadharDao;
	
	@Autowired
	private PanDao panDao;
	
	@Autowired
	private DlDao dlDao;
	
	
	@Override
	public Iterable<AadharData> getAadhar() {
		return aadharDao.findAll();
	}

	@Override
	public Optional<AadharData> getAadhar(String aadhar) {
		return aadharDao.findById(aadhar);
	}

	@Override
	public Iterable<AadharData> getAadharFirstName(String first_name) {
		return aadharDao.findByFirstName(first_name);
	}
	
	@Override
	public Iterable<AadharData> getAadharLastName(String last_name) {
		return aadharDao.findByLastName(last_name);
	}

	@Override
	public Iterable<AadharData> getAadharDob(String dob) {
		return aadharDao.findByDob(dob);
	}

	@Override
	public Iterable<AadharData> getAadharFname(String father_name) {
		return aadharDao.findByFatherName(father_name);
	}

	@Override
	public Iterable<AadharData> panAndAadharWithSimilarity(String pan) {
		ArrayList<AadharData> aadhars = new ArrayList<AadharData>();
		Optional<PanData> optionalPan = panDao.findById(pan);
		PanData panTemp = optionalPan.get();
		String panFirstName = panTemp.getFirstName(),
				panLastName = panTemp.getLastName(),
				panFname = panTemp.getFatherName(),
				panDob = panTemp.getDob(), 
				panCity = panTemp.getCity();
		
		
		Iterable<AadharData> iterableAadhar = aadharDao.findAll();
		Iterator<AadharData> itAadhar = iterableAadhar.iterator();
		while(itAadhar.hasNext()){
			AadharData temp = itAadhar.next();
			if((temp.getFatherName().equals(panFname) && temp.getCity().equals(panCity)) ||
					(temp.getDob().equals(panDob) && temp.getCity().equals(panCity)) || 
					(temp.getLastName().equals(panLastName) && temp.getCity().equals(panCity)) || 
					(temp.getLastName().equals(panLastName) && temp.getFatherName().equals(panFname)) ||
					(temp.getLastName().equals(panLastName) && temp.getDob().equals(panDob)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getCity().equals(panCity)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getLastName().equals(panLastName)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getDob().equals(panDob)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getFatherName().equals(panFname)) ||
					(temp.getDob().equals(panDob) && temp.getFatherName().equals(panFname))) {
				aadhars.add(temp);
			}
		}
		
		if(aadhars.isEmpty()) {
			aadhars.add(new AadharData(null, null, null, null, null, null));
		}
		return aadhars;
	}

	@Override
	public Iterable<AadharData> getAadharCity(String city) {
		return aadharDao.findByCity(city);
	}

	@Override
	public Iterable<AadharData> dlAndAadharWithSimilarity(String driving_liscence) {
		ArrayList<AadharData> aadhars = new ArrayList<AadharData>();
		Optional<DlData> optionalDl = dlDao.findById(driving_liscence);
		DlData dlTemp = optionalDl.get();
		String dlFirstName = dlTemp.getFirstName(),
				dlLastName = dlTemp.getLastName(),
				dlFname = dlTemp.getFatherName(),
				dlDob = dlTemp.getDob(), 
				dlCity = dlTemp.getCity();
		
		
		Iterable<AadharData> iterableAadhar = aadharDao.findAll();
		Iterator<AadharData> itAadhar = iterableAadhar.iterator();
		while(itAadhar.hasNext()){
			AadharData temp = itAadhar.next();
			if((temp.getFatherName().equals(dlFname) && temp.getCity().equals(dlCity)) ||
					(temp.getDob().equals(dlDob) && temp.getCity().equals(dlCity)) || 
					(temp.getLastName().equals(dlLastName) && temp.getCity().equals(dlCity)) || 
					(temp.getLastName().equals(dlLastName) && temp.getFatherName().equals(dlFname)) ||
					(temp.getLastName().equals(dlLastName) && temp.getDob().equals(dlDob)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getCity().equals(dlCity)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getLastName().equals(dlLastName)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getDob().equals(dlDob)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getFatherName().equals(dlFname)) ||
					(temp.getDob().equals(dlDob) && temp.getFatherName().equals(dlFname))) {
				aadhars.add(temp);
			}
		}
		
		if(aadhars.isEmpty()) {
			aadhars.add(new AadharData(null, null, null, null, null, null));
		}
		return aadhars;
	}
}
