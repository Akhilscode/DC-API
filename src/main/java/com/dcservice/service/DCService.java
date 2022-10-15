package com.dcservice.service;

import java.util.List;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;

public interface DCService {
   
	public boolean createCase(Integer appId);
	
	public List<String>  getAllPlans();
	
	public boolean addEducationDetails(EducationInfo einfo);
	
	public boolean addIncomeDetails(IncomeInfo iInfo);
	
	public boolean addkidsDetails(KidsInfo kinfo);
	
	public DCSummary getSummary(Integer caseId);
	
}
