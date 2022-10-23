package com.dcservice.bindings;

import java.util.List;

import lombok.Data;

@Data
public class KidsRequest {
	
	private Long caseNum;
	
	private List<KidsInfo> listkidsinfo;

}
