package com.dcservice.bindings;

import lombok.Data;

@Data
public class IncomeInfo {
	private Integer caseNum;
	private Long empIncome;
	private Long propertyIncome;
	private Long otherIncome;
}
