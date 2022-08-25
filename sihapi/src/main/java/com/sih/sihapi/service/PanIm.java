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
public class PanIm implements PanService {

	@Autowired
	private PanDao panDao;
	
	@Autowired
	private AadharDao aadharDao;
	
	@Autowired
	private DlDao dlDao;
	
	@Override
	public Iterable<PanData> getPan() {
		return panDao.findAll();
	}

	@Override
	public Optional<PanData> getPan(String pan) {
		return panDao.findById(pan);
	}

	@Override
	public Iterable<PanData> getPanFirstName(String first_name) {
		return panDao.findByFirstName(first_name);
	}

	@Override
	public Iterable<PanData> getPanLastName(String last_name) {
		return panDao.findByLastName(last_name);
	}

	@Override
	public Iterable<PanData> getPanDob(String dob) {
		return panDao.findByDob(dob);
	}

	@Override
	public Iterable<PanData> getPanFatherName(String father_name) {
		return panDao.findByFatherName(father_name);
	}
	
	@Override
	public Iterable<PanData> getPanCity(String city) {
		return panDao.findByCity(city);
	}
	
	@Override
	public Iterable<PanData> aadharAndPanWithSimilarity(String aadhar) {
		ArrayList<PanData> pans = new ArrayList<PanData>();
		Optional<AadharData> optionalAadhar = aadharDao.findById(aadhar);
//		if(optionalAadhar == null)
//			return null;
		AadharData aadharTemp = optionalAadhar.get();
		String aadharFirstName = aadharTemp.getFirstName(),
				aadharLastName = aadharTemp.getLastName(),
				aadharFname = aadharTemp.getFatherName(),
				aadharDob = aadharTemp.getDob(),
				aadharCity = aadharTemp.getCity();
		
		
		Iterable<PanData> iterablePan = panDao.findAll();
		Iterator<PanData> itPan = iterablePan.iterator();
		while(itPan.hasNext()){
			PanData temp = itPan.next();
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
				pans.add(temp);
				System.out.println("Added with pan no. : " + temp.getPan());
			}
		}
		
		if(pans.isEmpty()) {
			pans.add(new PanData(null, null, null, null, null, null));
		}
		return pans;
	}

	@Override
	public Iterable<PanData> dlAndPanWithSimilarity(String driving_liscence) {
		ArrayList<PanData> pans = new ArrayList<PanData>();
		Optional<DlData> optionalDl = dlDao.findById(driving_liscence);
		DlData dlTemp = optionalDl.get();
		String dlFirstName = dlTemp.getFirstName(),
				dlLastName = dlTemp.getLastName(),
				dlFname = dlTemp.getFatherName(),
				dlDob = dlTemp.getDob(),
				
				dlCity = dlTemp.getCity();
		
		
		Iterable<PanData> iterablePan = panDao.findAll();
		Iterator<PanData> itPan = iterablePan.iterator();
		while(itPan.hasNext()){
			PanData temp = itPan.next();
			if((temp.getFatherName().equals(dlFname) && temp.getCity().equals(dlCity)) ||
					(temp.getDob().equals(dlDob) && temp.getCity().equals(dlCity)) || 
					(temp.getLastName().equals(dlLastName) && temp.getCity().equals(dlCity)) || 
					(temp.getLastName().equals(dlLastName) && temp.getFatherName().equals(dlFname)) ||
					(temp.getLastName().equals(dlLastName) && temp.getDob().equals(dlDob)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getCity().equals(dlCity)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getLastName().equals(dlLastName))||
					(temp.getFirstName().equals(dlFirstName) && temp.getDob().equals(dlDob)) || 
					(temp.getFirstName().equals(dlFirstName) && temp.getFatherName().equals(dlFname)) ||
					(temp.getDob().equals(dlDob) && temp.getFatherName().equals(dlFname))) {
				pans.add(temp);
				System.out.println("Added with pan no. : " + temp.getPan());
			}
		}
		
		if(pans.isEmpty()) {
			pans.add(new PanData(null, null, null, null, null, null));
			return pans;
		}
		return pans;
	}

}
