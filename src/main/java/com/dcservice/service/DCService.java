package com.dcservice.service;

import java.util.List;
import java.util.Map;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;
import com.dcservice.bindings.PlanInfo;


public interface DCService {
   
	public Long loadCaseNum(Integer appId);
	
	public Map<Integer, String>  getPlanNames();
	
	public Long savePlanSelection(PlanInfo pi);
	
	public Long addIncomeDetails(IncomeInfo iInfo);
	
	public Long addEducationDetails(EducationInfo einfo);
	
	public Long addkidsDetails(List<KidsInfo> kinfo);
	
	public DCSummary getSummary(Long caseNum);
	
}
