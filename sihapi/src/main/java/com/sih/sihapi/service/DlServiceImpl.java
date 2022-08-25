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
public class DlServiceImpl implements DlService {

	@Autowired
	private DlDao dlDao;
	
	@Autowired
	private AadharDao aadharDao;
	
	@Autowired
	private PanDao panDao;

	@Override
	public Iterable<DlData> getDl() {
		return dlDao.findAll();
	}

	@Override
	public Optional<DlData> getDl(String pan) {
		return dlDao.findById(pan);
	}

	@Override
	public Iterable<DlData> getDlFirstName(String first_name) {
		return dlDao.findByFirstName(first_name);
	}

	@Override
	public Iterable<DlData> getDlLastName(String last_name) {
		return dlDao.findByLastName(last_name);
	}

	@Override
	public Iterable<DlData> getDlDob(String dob) {
		return dlDao.findByDob(dob);
	}

	@Override
	public Iterable<DlData> getDlFname(String father_name) {
		return dlDao.findByFatherName(father_name);
	}

	@Override
	public Iterable<DlData> getDlCity(String city) {
		return dlDao.findByCity(city);
	}

	@Override
	public Iterable<DlData> aadharAndDlWithSimilarity(String aadhar) {
		ArrayList<DlData> dls = new ArrayList<DlData>();
		Optional<AadharData> optionalAadhar = aadharDao.findById(aadhar);
		AadharData aadharTemp = optionalAadhar.get();
		String aadharFirstName = aadharTemp.getFirstName(),
				aadharLastName = aadharTemp.getLastName(),
				aadharFname = aadharTemp.getFatherName(),
				aadharDob = aadharTemp.getDob(),
				aadharCity = aadharTemp.getCity();
		
		
		Iterable<DlData> iterableDl = dlDao.findAll();
		Iterator<DlData> itDl = iterableDl.iterator();
		while(itDl.hasNext()){
			DlData temp = itDl.next();
			if((temp.getFatherName().equals(aadharFname) && temp.getCity().equals(aadharCity)) ||
					(temp.getDob().equals(aadharDob) && temp.getCity().equals(aadharCity)) || 
					(temp.getLastName().equals(aadharLastName) && temp.getCity().equals(aadharCity)) || 
					(temp.getLastName().equals(aadharLastName) && temp.getFatherName().equals(aadharFname)) ||
					(temp.getLastName().equals(aadharLastName) && temp.getDob().equals(aadharDob)) || 
					(temp.getFirstName().equals(aadharFirstName) && temp.getCity().equals(aadharCity)) || 
					(temp.getFirstName().equals(aadharFirstName) && temp.getLastName().equals(aadharLastName))||
					(temp.getFirstName().equals(aadharFirstName) && temp.getDob().equals(aadharDob)) || 
					(temp.getFirstName().equals(aadharFirstName) && temp.getFatherName().equals(aadharFname)) ||
					(temp.getDob().equals(aadharDob) && temp.getFatherName().equals(aadharFname))) {
				dls.add(temp);
				System.out.println("Added with pan no. : " + temp.getDriving_liscence());
			}
		}
		
		if(dls.isEmpty()) {
			dls.add(new DlData(null, null, null, null, null, null));
		}
		return dls;
	}

	@Override
	public Iterable<DlData> panAndDlWithSimilarity(String pan) {
		ArrayList<DlData> dls = new ArrayList<DlData>();
		Optional<PanData> optionalPan = panDao.findById(pan);
		PanData panTemp = optionalPan.get();
		String panFirstName = panTemp.getFirstName(),
				panLastName = panTemp.getLastName(),
				panFname = panTemp.getFatherName(),
				panDob = panTemp.getDob(),
				panCity = panTemp.getCity();
		
		
		Iterable<DlData> iterableDl = dlDao.findAll();
		Iterator<DlData> itDl = iterableDl.iterator();
		while(itDl.hasNext()){
			DlData temp = itDl.next();
			if((temp.getFatherName().equals(panFname) && temp.getCity().equals(panCity)) ||
					(temp.getDob().equals(panDob) && temp.getCity().equals(panCity)) || 
					(temp.getLastName().equals(panLastName) && temp.getCity().equals(panCity)) || 
					(temp.getLastName().equals(panLastName) && temp.getFatherName().equals(panFname)) ||
					(temp.getLastName().equals(panLastName) && temp.getDob().equals(panDob)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getCity().equals(panCity)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getLastName().equals(panLastName))||
					(temp.getFirstName().equals(panFirstName) && temp.getDob().equals(panDob)) || 
					(temp.getFirstName().equals(panFirstName) && temp.getFatherName().equals(panFname)) ||
					(temp.getDob().equals(panDob) && temp.getFatherName().equals(panFname))) {
				dls.add(temp);
				System.out.println("Added with pan no. : " + temp.getDriving_liscence());
			}
		}
		
		if(dls.isEmpty()) {
			dls.add(new DlData(null, null, null, null, null, null));
		}
		return dls;
	}
	
	

}
