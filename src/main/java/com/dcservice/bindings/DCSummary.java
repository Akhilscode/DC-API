package com.dcservice.bindings;

import java.util.List;

import lombok.Data;

@Data
public class DCSummary {
	
	private String planName;
	
	private EducationInfo einfo;
	
	private IncomeInfo iInfo;
	
	private List<KidsInfo> kinfo;

}
