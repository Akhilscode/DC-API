package com.dcservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcservice.bindings.CreateCaseResponse;
import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;
import com.dcservice.bindings.PlanInfo;
import com.dcservice.service.DCService;

@RestController
public class DCController {
	
	@Autowired
	private DCService service;
	
	@GetMapping("/createCase/{appId}")
	public ResponseEntity<CreateCaseResponse> createCaseId(@PathVariable Integer appId){
		Long caseNum = service.loadCaseNum(appId);
		Map<Integer, String> planNames = service.getPlanNames();
		
		CreateCaseResponse response = new CreateCaseResponse();
		response.setCaseNum(caseNum);
		response.setPlanNames(planNames);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/selectplan")
	public ResponseEntity<Long> selectPlan(@RequestBody PlanInfo pi){
		Long caseNum = service.savePlanSelection(pi);
		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);
	}
	
	@PostMapping("/IncomeInfo")
	public ResponseEntity<Long> submitIncomeDetails(@RequestBody IncomeInfo iInfo){
		Long caseNum = service.addIncomeDetails(iInfo);
		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);
	}
	
	@PostMapping("/educationInfo")
	public ResponseEntity<Long> submitEducationDetails(@RequestBody EducationInfo einfo){
		Long caseNum = service.addEducationDetails(einfo);
		return new ResponseEntity<Long>(caseNum, HttpStatus.CREATED);
	}
	
	@PostMapping("/kidsInfo")
	public ResponseEntity<Long> submitKidsDetails(@RequestBody List<KidsInfo>  lstkinfo){
		Long caseNum = service.addkidsDetails(lstkinfo);
		//DCSummary summary = service.getSummary(caseNum);
		return new ResponseEntity<Long>(caseNum, HttpStatus.OK);
	}
	
	@GetMapping("/getsummary/{caseNum}")
	public ResponseEntity<DCSummary> getSummary(@PathVariable Long caseNum){
		DCSummary summary = service.getSummary(caseNum);
		return new ResponseEntity<DCSummary>(summary, HttpStatus.OK);
	}
	
}
