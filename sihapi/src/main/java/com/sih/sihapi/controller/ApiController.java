package com.sih.sihapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sih.sihapi.entities.AadharData;
import com.sih.sihapi.entities.DlData;
import com.sih.sihapi.entities.PanData;
import com.sih.sihapi.service.AadharService;
import com.sih.sihapi.service.DlService;
import com.sih.sihapi.service.PanService;

@RestController
public class ApiController {
	
	@Autowired
	private AadharService aadharService;
	
	@Autowired
	private PanService panService;
	
	@Autowired
	private DlService dlService;
	
	/*
	 * Aadhar Data
	*/
	
	@GetMapping("/aadhar")
	public Iterable<AadharData> getAadhar() {
		return this.aadharService.getAadhar();
	}
	
	@GetMapping("/aadhar/{aadhar}")
	public Optional<AadharData> getAadhar(@PathVariable String aadhar) {
		return this.aadharService.getAadhar(aadhar);
	}
	
	@GetMapping("/aadhar/firstName/{first_name}")
	public Iterable<AadharData> getAadharFirstName(@PathVariable String first_name){
		return this.aadharService.getAadharFirstName(first_name);
	}
	
	@GetMapping("/aadhar/lastName/{last_name}")
	public Iterable<AadharData> getAadharLastName(@PathVariable String last_name){
		return this.aadharService.getAadharLastName(last_name);
	}
	
	/*
	@GetMapping("/aadhar/dob/{dob}")
	public Iterable<AadharData> getAadharDob(@PathVariable String dob){
		return this.aadharService.getAadharDob(dob);
	}
	*/
	
	@GetMapping("/aadhar/fatherName/{father_name}")
	public Iterable<AadharData> getAadharFname(@PathVariable String father_name){
		return this.aadharService.getAadharFname(father_name);
	}
	
	@GetMapping("/aadhar/city/{city}")
	public Iterable<AadharData> getAadharCity(@PathVariable String city){
		return this.aadharService.getAadharCity(city);
	}
	
	@GetMapping("/pan/aadhar/{panNo}")
	public Iterable<AadharData> panAndAadharWithSimilarity(@PathVariable String panNo){
		return this.aadharService.panAndAadharWithSimilarity(panNo);
	}
	
	@GetMapping("/dl/aadhar/{driving_liscence}")
	public Iterable<AadharData> dlAndAadharWithSimilarity(@PathVariable String driving_liscence){
		return this.aadharService.dlAndAadharWithSimilarity(driving_liscence);
	}
	/*
	 * PAN Data
	 */
	
	@GetMapping("/pan")
	public Iterable<PanData> getPan(){
		return this.panService.getPan();
	}
	
	@GetMapping("/pan/{pan}")
	public Optional<PanData> getPan(@PathVariable String pan){
		return this.panService.getPan(pan);
	}
	
	@GetMapping("/pan/firstName/{first_name}")
	public Iterable<PanData> getPanFirstName(@PathVariable String first_name){
		return this.panService.getPanFirstName(first_name);
	}
	
	@GetMapping("/pan/lastName/{last_name}")
	public Iterable<PanData> getPanLastName(@PathVariable String last_name){
		return this.panService.getPanLastName(last_name);
	}
	
	/*
	@GetMapping("/pan/dob/{dob}")
	public Iterable<PanData> getPanDob(@PathVariable String dob){
		return this.panService.getPanDob(dob);
	}
	*/
	@GetMapping("/pan/fatherName/{father_name}")
	public Iterable<PanData> getPanFname(@PathVariable String father_name){
		return this.panService.getPanFatherName(father_name);
	}
	
	@GetMapping("/pan/city/{city}")
	public Iterable<PanData> getPanCity(@PathVariable String city){
		return this.panService.getPanCity(city);
	}
	
	@GetMapping("/aadhar/pan/{aadharNo}")
	public Iterable<PanData> aadharAndPanWithSimilarity(@PathVariable String aadharNo){
		return this.panService.aadharAndPanWithSimilarity(aadharNo);
	}
	
	@GetMapping("/dl/pan/{driving_liscence}")
	public Iterable<PanData> dlAndPanWithSimilarity(@PathVariable String driving_liscence){
		return this.panService.dlAndPanWithSimilarity(driving_liscence);
	}
	/*
	 * Driving Liscence
	 */
	
	@GetMapping("/dl")
	public Iterable<DlData> getDl() {
		return this.dlService.getDl();
	}
	
	@GetMapping("/dl/{driving_liscence}")
	public Optional<DlData> getDl(@PathVariable String driving_liscence) {
		return this.dlService.getDl(driving_liscence);
	}
	
	@GetMapping("/dl/firstName/{first_name}")
	public Iterable<DlData> getDlFirstName(@PathVariable String first_name){
		return this.dlService.getDlFirstName(first_name);
	}
	
	@GetMapping("/dl/lastName/{last_name}")
	public Iterable<DlData> getDlLastName(@PathVariable String last_name){
		return this.dlService.getDlLastName(last_name);
	}
	
	/*
	@GetMapping("/dl/dob/{dob}")
	public Iterable<DlData> getDlDob(@PathVariable String dob){
		return this.dlService.getDlDob(dob);
	}
	*/
	
	@GetMapping("/dl/fatherName/{father_name}")
	public Iterable<DlData> getDlFname(@PathVariable String father_name){
		return this.dlService.getDlFname(father_name);
	}
	
	@GetMapping("/dl/city/{city}")
	public Iterable<DlData> getDlCity(@PathVariable String city){
		return this.dlService.getDlCity(city);
	}
	
	@GetMapping("/aadhar/dl/{aadhar}")
	public Iterable<DlData> aadharAndDlWithSimilarity(@PathVariable String aadhar){
		return this.dlService.aadharAndDlWithSimilarity(aadhar);
	}
	
	@GetMapping("/pan/dl/{pan}")
	public Iterable<DlData> panAndDlWithSimilarity(@PathVariable String pan){
		return this.dlService.panAndDlWithSimilarity(pan);
	}
	
	
}
