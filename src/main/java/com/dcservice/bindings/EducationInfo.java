package com.dcservice.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EducationInfo {

	private Integer caseNum;
	private String qualification;
	private LocalDate year;
}
