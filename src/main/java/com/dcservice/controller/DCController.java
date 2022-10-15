package com.dcservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;

@RestController
public class DCController {
	
	@GetMapping("/createCase/{appId}")
	public ResponseEntity<Integer> createCaseId(@PathVariable Integer appId){
		return null;
	}
	
	@GetMapping("/getPlans")
	public ResponseEntity<List<String>> getAllPlans(){
		return null;
	}
	
	@PostMapping("/educationInfo")
	public ResponseEntity<String> submitEducationDetails(@RequestBody EducationInfo einfo){
		return null;
	}
	
	@PostMapping("/kidsInfo")
	public ResponseEntity<String> submitKidsDetails(@RequestBody List<KidsInfo>  lstkinfo){
		return null;
	}
	
	@PostMapping("/IncomeInfo")
	public ResponseEntity<String> submitIncomeDetails(@RequestBody IncomeInfo iInfo){
		return null;
	}
	
	@GetMapping("/summary/{caseId}")
	public ResponseEntity<DCSummary> getDCSummary(@PathVariable Integer caseId){
		return null;
	}

}
