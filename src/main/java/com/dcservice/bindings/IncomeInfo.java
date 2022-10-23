package com.dcservice.bindings;

import lombok.Data;

@Data
public class IncomeInfo {
	private Long  caseNum;
	private Double empIncome;
	private Double propertyIncome;
	private Double otherIncome;
}
