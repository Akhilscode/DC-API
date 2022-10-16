package com.dcservice.service;

import java.util.List;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;

public interface DCService {
   
	public Long findAppId(Integer appId);
	
	public List<String>  getAllPlans();
	
	public Long addEducationDetails(EducationInfo einfo);
	
	public Long addIncomeDetails(IncomeInfo iInfo);
	
	public Long addkidsDetails(List<KidsInfo> kinfo);
	
	public DCSummary getSummary(Integer caseId);
	
}
